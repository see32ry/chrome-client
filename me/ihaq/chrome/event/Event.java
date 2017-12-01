package me.ihaq.chrome.event;

import java.lang.reflect.InvocationTargetException;

import me.ihaq.chrome.Chrome;

public abstract class Event {

    private boolean cancelled;
    private Type type;

    public Event(Type type) {
        this.type = type;
        cancelled = false;
    }

    /**
     * The event can be either PRE or POST.
     */
    public enum Type {
        PRE, POST
    }

    public void call() {
        cancelled = false;

        ArrayHelper<Data> dataList = Chrome.INSTANCE.EVENT_MANAGER.get(this.getClass());

        if (dataList != null) {
            for (Data data : dataList) {
                try {
                    data.target.invoke(data.source, this);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Returns the type of the event PRE or POST
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns weather the event was canceled or not.
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Allows you to set the event to cancelled.
     */
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }


}