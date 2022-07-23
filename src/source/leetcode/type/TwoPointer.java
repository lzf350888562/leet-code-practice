package source.leetcode.type;

import java.util.*;

import static source.leetcode.esay.linked.MergeTwoLists.ListNode;

/**
 * 双指针
 * 167. 两数之和 II - 输入有序数组 前后指针
 * 88. 合并两个有序数组 同时同向指针
 * 142. 环形链表 II     快慢指针
 * 76. 最小覆盖子串   滑动窗口
 * 633. 平方数之和   前后指针
 * 524. 通过删除字母匹配到字典里最长单词 同时同向指针
 */
public class TwoPointer {
    /**
     * 167. 两数之和 II - 输入有序数组  左右指针
     */
    public int[] twoSum(int[] numbers, int target) {
        int front = 0, end = numbers.length - 1;
        while (front != end) {
            if (numbers[front] + numbers[end] > target) {
                end--;
            } else if (numbers[front] + numbers[end] < target) {
                front++;
            } else {
                //题目下标从1开始计数
                return new int[]{front, end};
            }
        }
        return new int[]{0, 0};
    }

    /**
     * 88. 合并两个有序数组
     * 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        for (m--, n--; m >= 0 && n >= 0; ) {
            if (nums1[m] > nums2[n]) {
                nums1[pos] = nums1[m];
                m--;
            } else {
                nums1[pos] = nums2[n];
                n--;
            }
            pos--;
        }
        while (n >= 0) {
            nums1[pos] = nums2[n];
            pos--;
            n--;
        }
    }

    /**
     * 快慢指针
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 每次 fast 前进两步，slow 前进一步。如果 fast可以走到尽头，那么说明没有环路；
     * 如果 fast 可以无限走下去，那么说明一定有环路，且一定存在一个时刻 slow 和 fast 相遇。
     * <p>
     * 当 slow 和 fast 第一次相遇时，让head前进一步 ,并让 slow 或 fast 也前进一步。
     * 当 head 与 slow 或 fast 相遇时，相遇的节点即为环路的开始点。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

    /**
     * 76. 最小覆盖子串  滑动窗口
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
     * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
     * <p>
     * 用l,r表示滑动窗口的左边界和右边界，通过改变l,r来扩展和收缩滑动窗口，可以想象成一个窗口在字符串上游走，
     * 当这个窗口包含的元素满足条件，即包含字符串T的所有元素，记录下这个滑动窗口的长度r-l+1，这些长度中的最小值就是要求的结果。
     *
     * 滑动窗口关键需要知道何时通过移动右侧指针扩大窗口, 何时通过左侧指针缩小窗口
     */
    public String minWindow(String s, String t) {
        if (s == null || t.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        // 将需要的字符个数记录下(t)
        int[] window = new int[128];
        for (int i = 0; i < t.length(); i++) {
            window[t.charAt(i)] += 1;
        }

        int right = 0, left = 0, count = t.length(), size = Integer.MAX_VALUE, start = 0;
        // 扩大窗口,先找到满足含有t s的字串
        while (right < s.length()) {
            // window里>=0都是需要的count,<0的都是非必要字符
            char c = s.charAt(right);
            // 判断窗口是否需要当前元素,需要的话count-1
            if (window[c] > 0) {
                count--;
            }
            window[c] -= 1; // 更新想要得到的窗口
            // 当count=0 说明需要的字符都被找到了,左指针右移 缩小窗口,直到刚好满足count==0
            if (count == 0) {
                while (window[s.charAt(left)] < 0) {
                    window[s.charAt(left)]++;
                    left++;
                }
                // 确定好新的窗口 在每个新的窗口中 找最小的窗口
                if (right - left < size) {
                    // size指向下标为确定好窗口的最后一个字符
                    size = right - left;
                    start = left;
                }
                // 开始下一个窗口的寻找 这时候left指向的s字串 是t的第一个字符
                // 我们要看剩下的字串中有没有满足的, 首先让当前指向的字符不算,然后指针右移
                window[s.charAt(left)]++;
                left++;
                count++;
            }
            right++; // 右指针不断右移,窗口不断扩大
        }

        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size + 1);
    }

    /**
     * 633. 平方数之和
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
     * <p>
     * 与two sum一样
     * 左指针 从0开始  右指针 从根号c开始
     */
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            //防止越界
            if (left * left - c + right * right > 0) {
                right--;
            } else if (left * left + right * right < c) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 680. 验证回文字符串 Ⅱ
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     */
    public boolean validPalindrome(String s) { //注意 是删除 不是替换
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isValid(s, left, right - 1)) {
                    return true;
                } else if (isValid(s, left + 1, right)) {
                    return true;
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 524. 通过删除字母匹配到字典里最长单词 (字典序)
     * 一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
     * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
     * 题目只删除s中word前面和后面的单词
     * 双指针 一个从s开始 一个从单词开始
     */
    public String findLongestWord(String s, List<String> dictionary) {
        //因为第一要求为长, 第二要求字典序优先
        //所以先根据长度倒序, 再根据字典序
        dictionary.sort(Comparator.comparingInt(String::length).reversed().thenComparing(String::compareTo));
        //接下来一个个去匹配就行了 匹配到就直接返回 它肯定是最符合条件的
        for (String word : dictionary) {
            int i=0,j=0;
            while(i<s.length() && j<word.length()){
                if (s.charAt(i) == word.charAt(j)) j++;
                i++;
            }
            //表示s中存在word子串
            if (j == word.length()) return word;
        }
        return "";
    }



    public static void main(String[] args) {
        System.out.println(new TwoPointer().validPalindrome("deeee"));
    }
}
