package com.endava.moderator.utils;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * $Revision: 343 $
 * $Author: igorgos $
 * $Date: 2012-03-27 06:05:30 +0300 (Ma, 27 mar. 2012) $
 * Description : Class EmptyDetector is an utility class that is
 * used for certain checks to be performed.
 */
public class EmptyDetector implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 718359585803169450L;
	/**
	 * method isEmpty(String)
	 * Checks if a String is null or Empty
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return !(str != null && str.length() > 0);
	}

	/**
	 * method isEmpty(String)
	 * Checks if a String is null or Empty
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(StringBuffer str) {
		return !(str != null && str.length() > 0);
	}

	/**
	 * method isEmpty(Map)
	 * Checks if a Map is null or Empty
	 * @param map
	 * @return boolean
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return !(map != null && map.size() > 0);
	}

	/**
	 * method isEmpty(List)
	 * Checks if a List is null or Empty
	 * @param list
	 * @return boolean
	 */
	public static boolean isEmpty(List<?> list) {
		return !(list != null && list.size() > 0);
	}

	/**
	 * method isEmpty(Set)
	 * Checks if a Set is null or Empty
	 * @param set
	 * @return boolean
	 */
	public static boolean isEmpty(Set<?> set) {
		return set == null || set.isEmpty();
	}

	/**
	 * Method isEmpty(Object)
	 * Checks if a Object is null or Empty
	 * @param obj
	 * @return boolean
	 */
	public static boolean isEmpty(Object obj) {
		if (obj instanceof String) {
			return isEmptyString((String) obj);
		} else if (obj instanceof Integer) {
			return isEmpty((Integer) obj);
		} else if (obj instanceof Long) {
			return isEmpty((Long) obj);
		} else if (obj != null) {
			if (obj.getClass().isArray()) {
				if (Array.getLength(obj) == 0) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	/**
	 * Method isEmpty(Long)
	 * Checks if a Long is null or is equals to 0.
	 * @param obj object to check
	 * @return boolean
	 */
	public static boolean isEmpty(Long obj) {
		if (obj == null || obj == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Method isEmpty(Integer)
	 * Checks if a Integer is null or is equals to 0.
	 * @param obj object to check
	 * @return boolean
	 */
	public static boolean isEmpty(Integer obj) {
		if (obj == null || obj == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Method isEmpty(BigDecimal)
	 * Checks if a Integer is null or is equals to 0.
	 * @param obj object to check
	 * @return boolean
	 */
	public static boolean isEmpty(BigDecimal obj) {
		if (obj == null || obj == BigDecimal.ZERO) {
			return true;
		}
		return false;
	}

	/**
	 * Method isEmpty(Boolean)
	 * Checks if a Boolean is null or is false.
	 * @param obj object to check
	 * @return boolean
	 */
	public static boolean isEmpty(Boolean obj) {
		if (obj == null || (! obj)) {
			return true;
		}
		return false;
	}

	/**
	 * Method isEmpty(Double)
	 * Checks if a Double is null or is 0.
	 * @param obj object to check
	 * @return boolean
	 */
	public static boolean isEmpty(Double obj) {
		if (obj == null || obj == 0D || obj == 0.0) {
			return true;
		}
		return false;
	}

	/**
	 * Method isNotEmpty(Long)
	 * Checks if a Long is not null and is not equals to 0.
	 * @param obj object to check
	 * @return boolean
	 */
	public static boolean isNotEmpty(Long obj) {
		if (obj != null && obj != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Method isNotEmpty(Integer)
	 * Checks if a Integer is not null and is not equals to 0.
	 * @param obj object to check
	 * @return boolean
	 */
	public static boolean isNotEmpty(Integer obj) {
		if (obj != null && obj != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Method isNotEmpty(BigDecimal)
	 * Checks if a BigDecimal is not null and is not equals to 0.
	 * @param obj object to check
	 * @return boolean
	 */
	public static boolean isNotEmpty(BigDecimal obj) {
		if (obj == null || obj.compareTo(BigDecimal.ZERO) == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Method isNotEmpty(Boolean)
	 * Checks if a Boolean is not null and is true.
	 * @param obj object to check
	 * @return boolean
	 */
	public static boolean isNotEmpty(Boolean obj) {
		if (obj != null && (obj)) {
			return true;
		}
		return false;
	}

	/**
	 * method isNotEmpty(Object)
	 * Checks if a String is not empty
	 * @param str
	 * @return boolean
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * method isNotEmpty(Object)
	 * Checks if a String is not empty
	 * @param str
	 * @return boolean
	 */
	public static boolean isNotEmpty(StringBuffer str) {
		return !isEmpty(str);
	}

	/**
	 * method isNotEmpty(Map)
	 * Checks if a Map is not empty
	 * @param map
	 * @return boolean
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}

	/**
	 * method isNotEmpty(List)
	 * Checks if a List is not empty
	 * @param list
	 * @return boolean
	 */
	public static boolean isNotEmpty(List<?> list) {
		return !isEmpty(list);
	}

	/**
	 * method isNotEmpty(Set)
	 * Checks if a Set is not empty
	 * @param set
	 * @return boolean
	 */
	public static boolean isNotEmpty(Set<?> set) {
		return !isEmpty(set);
	}

	/**
	 * method isNotEmpty(Double)
	 * Checks if a Object is null or is 0.0.
	 * @param obj
	 * @return boolean
	 */
	public static boolean isNotEmpty(Double obj) {
		return !isEmpty(obj);
	}

	/**
	 * method isNotEmpty(Object)
	 * Checks if a Object is not empty
	 * @param obj
	 * @return boolean
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	public static boolean areEmpty(Object... objects ) {
		boolean retValue = true;
		for (Object object : objects) {
			retValue = retValue && isEmpty(object);
		}
		return retValue;
	}
	/**
	 * method isEmptyString()
	 * Checks if a String is not null or Empty
	 * @param str
	 * @return boolean
	 */
	private static boolean isEmptyString(String str) {
		return !(str != null && str.length() > 0);
	}
}
