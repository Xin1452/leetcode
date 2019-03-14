package AddTwoNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: leetcode
 * @description: The solution for AddTwoNumbers
 * @author: Irving Wei
 * @create: 2019-03-13 11:42
 **/
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode cur = sum;
        // 进位
        int next = 0;
        while (l1 != null || l2 != null || next != 0) {
            int tmpSum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + next;

            next = tmpSum / 10;

            ListNode node = new ListNode(tmpSum % 10);
            cur.next = node;
            cur = node;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        return sum.next;
    }

    // 可以debug这个类做调试!
    public static class MainClass {
        public static int[] stringToIntegerArray(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return new int[0];
            }

            String[] parts = input.split(",");
            int[] output = new int[parts.length];
            for (int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }

        public static ListNode stringToListNode(String input) {
            // Generate array from the input
            int[] nodeValues = stringToIntegerArray(input);

            // Now convert that list into linked list
            ListNode dummyRoot = new ListNode(0);
            ListNode ptr = dummyRoot;
            for (int item : nodeValues) {
                ptr.next = new ListNode(item);
                ptr = ptr.next;
            }
            return dummyRoot.next;
        }

        public static String listNodeToString(ListNode node) {
            if (node == null) {
                return "[]";
            }

            String result = "";
            while (node != null) {
                result += Integer.toString(node.val) + ", ";
                node = node.next;
            }
            return "[" + result.substring(0, result.length() - 2) + "]";
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                ListNode l1 = stringToListNode(line);
                line = in.readLine();
                ListNode l2 = stringToListNode(line);

                ListNode ret = new Solution().addTwoNumbers(l1, l2);

                String out = listNodeToString(ret);

                System.out.print(out);
            }
        }
    }
}