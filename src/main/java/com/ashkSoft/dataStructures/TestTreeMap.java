//package com.ashkSoft.dataStructures;
//
//import com.ashkSoft.enums.IndEnum;
//import com.ashkSoft.enums.InsEnum;
//import com.ashkSoft.models.IndexWrapper;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class TestTreeMap<K,IndexWrapper> extends TreeMap<K,IndexWrapper> {
//
//    private static final boolean RED   = false;
//    private static final boolean BLACK = true;
//
////    @Override
////    public K put(Object key, Object value){
////
////    }
////
////    @Override
////    public IndexWrapper setValue(IndexWrapper value) {
////        IndexWrapper oldValue = value;
//////        this.value = value;
////        return oldValue;
////    }
//
//    static final boolean valEquals(Object o1, Object o2) {
//        return (o1==null ? o2==null : o1.equals(o2));
//    }
//
//    public class Entry<K,IndexWrapper> implements Map.Entry<K,IndexWrapper> {
//
//            K key;
//            IndexWrapper value;
//            IndicatorTreeMap.Entry<K,IndexWrapper> left;
//            Entry<K,IndexWrapper> right;
//            Entry<K,IndexWrapper> parent;
//            boolean color = BLACK;
//
//            /**
//             * Make a new cell with given key, value, and parent, and with
//             * {@code null} child links, and BLACK color.
//             */
//            Entry(K key, IndexWrapper value, Entry<K,IndexWrapper> parent) {
//                this.key = key;
//                this.value = value;
//                this.parent = parent;
//            }
//
//            /**
//             * Returns the key.
//             *
//             * @return the key
//             */
//            public K getKey() {
//                return key;
//            }
//
//            /**
//             * Returns the value associated with the key.
//             *
//             * @return the value associated with the key
//             */
//            public IndexWrapper getValue() {
//                return value;
//            }
//
//        @Override
//        public IndexWrapper setValue(IndexWrapper value) {
//            if (this.value!=null) {
//                IndexWrapper oldValue = this.value;
//                this.value.
////                oldValue.ge
////                this.value. = value;
////                return oldValue;
//            }
//        }
//
//        /**
//             * Replaces the value currently associated with the key with the given
//             * value.
//             *
//             * @return the value associated with the key before this method was
//             *         called
//             */
////            public V setValue(V value) {
////                V oldValue = this.value;
////                this.value = value;
////                return oldValue;
////            }
//
//
//            public boolean equals(Object o) {
//                if (!(o instanceof Map.Entry))
//                    return false;
//                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
//
//                return valEquals(key,e.getKey()) && valEquals(value,e.getValue());
//            }
//
//            public int hashCode() {
//                int keyHash = (key==null ? 0 : key.hashCode());
//                int valueHash = (value==null ? 0 : value.hashCode());
//                return keyHash ^ valueHash;
//            }
//
//            public String toString() {
//                return key + "=" + value;
//            }
//        }
//    }
//
