package com.github.rapid.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

public class CollectionHelperTest extends TestCase {
	List values = new ArrayList();
	public void setUp() {
		for(int i = 0; i < 10; i++) {
			values.add(i);
		}
	}
	
	@Test
	public void testSafeGet() {
		List list = new ArrayList();
		list.add("00");
		list.add("11");
		
		assertNull(CollectionUtil.safeGet(null, 10, null));
		assertEquals(1,CollectionUtil.safeGet(null, 10, 1));
		
		assertEquals("00",CollectionUtil.safeGet(list, 0, 1));
		assertEquals("11",CollectionUtil.safeGet(list, 1, 1));
		assertEquals(1,CollectionUtil.safeGet(list, 2, 1));
		assertEquals(1,CollectionUtil.safeGet(list, 3, 1));
		
	}
//	public void testMin() {
//		assertEquals(new Integer(0),(Integer)CollectionUtils.min(values,"class"));
//		
//		assertEquals(null,CollectionUtils.min(null,null));
//	}
//	
//	public void testMax() {
//		assertEquals(new Integer(9),(Integer)CollectionUtils.max(values,"class"));
//		assertEquals(null,CollectionUtils.max(null,null));
//	}
	
	public void testSum() {
		assertEquals(45,(long)CollectionUtil.sum(values));
		assertEquals(0,(long)CollectionUtil.sum(new ArrayList()));
		
		assertEquals(0,(long)CollectionUtil.sum(null));

	}
	
	@Test
	public void testlist2map() {
		List rows = new ArrayList();
		rows.add(MapUtil.newMap("id","1","name","badqiu"));
		rows.add(MapUtil.newMap("id","2","name","jane"));
		Map map = CollectionUtil.list2Map(rows, "id", "name");
		assertEquals("{1=badqiu, 2=jane}",map.toString());
	}
	
	public void testAvg() {
		assertEquals(4.5,(double)CollectionUtil.avg(values));
		assertEquals(0,(long)CollectionUtil.avg(new ArrayList()));
		
		assertEquals(0,(long)CollectionUtil.avg(null));
	}
	
	public void test_list2Map() {
//		CollectionUtil.list2Map(rows, key)
	}
}
