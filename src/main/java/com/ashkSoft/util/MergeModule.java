//package com.ashkSoft.util;
//
//import com.ashkSoft.enums.DirectionEnum;
//import com.ashkSoft.models.Index;
//
//public class MergeModule {
//
//    private DirectionEnum direction;
//
//    public DirectionEnum getDirection() {
//        return direction;
//    }
//
//    public void setDirection(DirectionEnum direction) {
//        this.direction = direction;
//    }
//
//    private Index sortedMerge(Index a, Index b)
//    {
//        Index result = null;
//        /* Base cases */
//        if (a == null)
//            return b;
//        if (b == null)
//            return a;
//
//        /* Pick either a or b, and recur */
//        switch (a.getValue().compareTo(b.getValue())) {
//            case -1:
//            case 0:
//                result = a;
//                result.setNext(sortedMerge(a.getNext(), b));
//                break;
//            case 1:
//                result = b;
//                result.setNext(sortedMerge(a, b.getNext()));
//        }
//        return result;
//    }
//
//    public Index mergeSort(Index head) {
//
//        // Base case : if head is null
//        if (head == null || head.getNext(head.DIRECTION) == null) {
//            return head;
//        }
//        DirectionEnum direction = head.DIRECTION;
//        // get the middle of the list
//        Index middle = getMiddle(head);
//        Index nextofmiddle = middle.getNext(direction);
//        nextofmiddle.DIRECTION=direction;
//        // set the next of middle node to null
//        middle.setNext(direction,null);
//
//        // Apply mergeSort on left list
//        Index left = mergeSort(head);
//        left.DIRECTION=direction;
//        // Apply mergeSort on right list
//        Index right = mergeSort(nextofmiddle);
//        right.DIRECTION=direction;
//        // Merge the left and right lists
//        return sortedMerge(left, right);
//    }
//
//    // Utility function to get the middle of the linked list
//    private Index getMiddle(Index head)
//    {
//        if (head == null)
//            return head;
//        DirectionEnum direction = head.DIRECTION;
//        Index slow = head, fast = head;
//
//        while (fast.getNext(direction) != null && fast.getNext(direction).getNext(direction) != null) {
//            slow = slow.getNext(direction);
//            fast = fast.getNext(direction).getNext(direction);
//        }
//        slow.DIRECTION=direction;
//        return slow;
//    }
//}
