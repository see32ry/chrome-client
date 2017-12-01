package me.ihaq.chrome.event;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EventManager {

	private HashMap<Class<? extends Event>, ArrayHelper<Data>> REGISTRY_MAP = new HashMap<Class<? extends Event>, ArrayHelper<Data>>();

	public void register(Object o) {
		for (Method method : o.getClass().getDeclaredMethods()) {
			if (!isMethodBad(method)) {
				register(method, o);
			}
		}
	}

	private void register(Method method, Object o) {

		Class<?> clazz = method.getParameterTypes()[0];
		Data methodData = new Data(o, method);

		if (!methodData.target.isAccessible()) {
			methodData.target.setAccessible(true);
		}

		if (REGISTRY_MAP.containsKey(clazz)) {
			if (!REGISTRY_MAP.get(clazz).contains(methodData)) {
				REGISTRY_MAP.get(clazz).add(methodData);
			}
		} else {
			REGISTRY_MAP.put((Class<? extends Event>) clazz, new ArrayHelper() {
				{
					this.add(methodData);
				}
			});
		}
	}

	public void unregister(Object o) {
		for (ArrayHelper<Data> flexibalArray : REGISTRY_MAP.values()) {
			for (Data methodData : flexibalArray) {
				if (methodData.source.equals(o)) {
					flexibalArray.remove(methodData);
				}
			}
		}
		cleanMap();
	}

	/**
	 * Goes through the hashmap and deletes and entry that are empty.
	 **/
	private void cleanMap() {
		REGISTRY_MAP.entrySet().removeIf(classArrayHelperEntry -> classArrayHelperEntry.getValue().isEmpty());
	}

	private boolean isMethodBad(Method method) {
		return method.getParameterTypes().length != 1 || !method.isAnnotationPresent(EventTarget.class);
	}

	public ArrayHelper<Data> get(Class<? extends Event> clazz) {
		return REGISTRY_MAP.get(clazz);
	}

}
