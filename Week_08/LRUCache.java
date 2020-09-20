/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2);
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回  1
        *cache.put(3,3);    // 该操作会使得关键字 2 作废
        *cache.get(2);       // 返回 -1 (未找到)
        *cache.put(4,4);    // 该操作会使得关键字 1 作废
        *cache.get(1);       // 返回 -1 (未找到)
        *cache.get(3);       // 返回  3
        *cache.get(4);       // 返回  4
 */

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, DLinkNode> map;
    private DLinkNode head, tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        this.head.next = tail;
        this.tail.prev = head;
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkNode node = map.get(key);
        if(null == node) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = map.get(key);
        if(null == node) {
            node = new DLinkNode(key, value);
            map.put(key, node);
            addToHead(node);
            size++;
            if(size > capacity) {
                DLinkNode removed = removeTail();
                map.remove(removed.key);
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private DLinkNode removeTail() {
        DLinkNode node = tail.prev;
        removeNode(node);
        return node;
    }

    class DLinkNode {
        int key, value;
        DLinkNode prev;
        DLinkNode next;
        DLinkNode(){}
        DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
