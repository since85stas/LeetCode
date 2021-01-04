class Solution {

    ListNode commonList = new ListNode();

    // TC - O(n + m)
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), current = dummyHead;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1 != null) current.next = l1;
        if(l2 != null) current.next = l2;

        return dummyHead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 ==null) {
            return l2;
        } else if (l2 == null){
            return l1;
        } else  {
            if (l1.val <= l2.val) {
                commonList.val = l1.val;
                commonList = common(l1.next, l2, commonList);
            } else {
                commonList.val = l2.val;
                commonList = common(l2.next, l1, commonList);
            }
            ListNode rev = reverse(commonList, null);
            return rev;
        }
    }

    private ListNode reverse(ListNode prim, ListNode rev) {
        if (prim != null) {
            rev = new ListNode(prim.val, rev);
            return reverse(prim.next, rev);
        } else  {
           return rev;
        }
    }

    private ListNode common(ListNode l1, ListNode l2, ListNode comL) {
        if (l1 == null && l2 != null) {
            return common(l2.next, l1, new ListNode(l2.val, comL));
        }
        else if (l2 == null && l1 != null) {
            return common(l1.next, l2, new ListNode(l1.val, comL));
        }
        else if (l1 != null || l2 != null) {
            if (l1.next != null) {
                if (l1.val <= l2.val) {
                    return common(l1.next, l2, new ListNode(l1.val, comL));
                } else {
                    return common(l2.next, l1, new ListNode(l2.val, comL));
                }
            } else  {
                if (l1.val <= l2.val) {
                    return common(l1.next, l2, new ListNode(l1.val, comL));
                } else {
                    return common(l2.next, l1, new ListNode(l2.val, comL));
                }
            }
        } else {
            return comL;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void fromListArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {

        }
    }
}

class Creator {
    int[] array;
    ListNode listNode;

    Creator(int[] array) {
        this.array = array;
    }

    ListNode create() {
        listNode = new ListNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            listNode = new ListNode(array[i], listNode);
        }
        return listNode;
    }
}

