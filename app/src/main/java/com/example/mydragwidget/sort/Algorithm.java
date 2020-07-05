package com.example.mydragwidget.sort;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.mydragwidget.BuildConfig;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Algorithm {
    public final static String TAG = BuildConfig.DEBUG ? "Algorithm" : null;

    public static void main() {
        Algorithm al = new Algorithm();

        int re = 693812;
        int re2 = -693812;

        Log.d(TAG, "reverseInt1 = " + al.reverseInt(re));
        Log.d(TAG, "reverseInt2 = " + al.reverseInt(re2));

//        String str = "eabdd";
        String str = "eabadd";
        Log.d(TAG, "longestPali = " + al.longestPali(str));
//        al.expandAroundCenter("fadafda",0,0);

//        String str2 = "abcdefabcyuioabcd";
        String str2 = "pwwkew";
        Log.d(TAG, "longestSubStrLen = " + al.longestSubStrLen(str2));
        Log.d(TAG, "longestSubStrLen2 = " + al.longestSubStrLen2(str2));

        String atoi1 = "123456";
        String atoi2 = "-8764321";
        Log.d(TAG, "atoi1 = " + al.myAtoi(atoi1));
        Log.d(TAG, "atoi2 = " + al.myAtoi(atoi2));

        int[] mediumArrays1 = {3,4,7,9,20,60,61,90};
        int[] mediumArrays2 = {5,6};
        int[] mediumArrays3 = {2,7};
//        mediumSortedArrays
        Log.d(TAG, "mediumSortedArrays 11 = " + al.mediumSortedArrays(mediumArrays1, mediumArrays2));
        Log.d(TAG, "mediumSortedArrays 12 = " + al.mediumSortedArrays(mediumArrays2, mediumArrays3));

        Node node1 = new Node(3);
        Node node2 = new Node(4);
        node1.next = node2;

        Node node3 = new Node(5);
        Node node4 = new Node(6);
        node3.next = node4;

        Node node5 = new Node(2);
        Node node6 = new Node(7);
        node5.next = node6;

/*        Node node = node1.merge2Lists(node1, node3);
        while (node != null) {
            Log.d(TAG, "node, val = " + node.val);
            node = node.next;
        }

        Node node_1 = node1.merge2Lists(node3, node5);
        while (node_1 != null) {
            Log.d(TAG, "node_1, val = " + node_1.val);
            node_1 = node_1.next;
        }*/

/*        Node node_2 = null;
        try {
            node_2 = node1.merge2Lists2(node1, node3);
            while (node_2 != null) {
                Log.d(TAG, "node_2, val = " + node_2.val);
                node_2 = node_2.next;
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/


        Node node_3 = node1.merge2Lists2(node3, node5);
        Node tt = node_3;
        while (tt != null) {
            Log.d(TAG, "node_3, val = " + tt.val);
            tt = tt.next;
        }

        String zStr = "PAYPALISHIRING";
        Log.d(TAG, "zConvert = " + al.zConvert(zStr, 5));

        String roman = "MCMXCIV";
        String roman2 = "MDCCCXCIV";
        Log.d(TAG, "roman2Int = " + al.roman2Int(roman));
        Log.d(TAG, "roman2Int2 = " + al.roman2Int(roman2));

        int num = 3890;
        int num2 = 2093;
        Log.d(TAG, "Int2Roman1 = " + al.Int2Roman(num));
        Log.d(TAG,"Int2Roman2 = " + al.Int2Roman(num2));

        Log.d(TAG, "integer break = " + al.integerBreak(7));
        Log.d(TAG, "integer break2 = " + al.integerBreak2(7));
        Log.d(TAG, "integer break3 = " + al.integerBreak3(19));

        Log.d(TAG, "dymIntegerSplit = " + al.dymIntegerSplit(7,7));
        Log.d(TAG, "climbStairs = " + al.climbStairs(6));

        Node node7 = new Node(7);
        Node node8 = new Node(3);
        Node node9 = new Node(1);
        Node node10 = new Node(8);
        Node node11 = new Node(6);
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        Node t = node1.sortList(node7);
        Node p = t;
        while (p != null) {
            Log.d(TAG, "p1.val = " + p.val);
            p = p.next;
        }

        Node q = node1.merge2Lists(node_3, t);
        p = q;
        while (p != null) {
            Log.d(TAG, "p2.val = " + p.val);
            p = p.next;
        }

        al.testBox();
    }

    public int reverseInt(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)) {
                return 0;
            }

            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }

        return rev;
    }

    public String longestPali(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }

        int start = 0, end = 0;
        for (int i =0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len -1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;

        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }

        return r-l-1;
    }

    public int longestSubStrLen(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();

        int ans = 0, i = 0, j = 0;
        while (i<n && j<n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
//                ++j;
                ans = Math.max(ans, j - i);

            } else {
                set.remove(s.charAt(i++));
//                ++i;
            }
        }

        return ans;
    }

    public int longestSubStrLen2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();

        int ans = 0, i = 0, j = 0;
        for (;j<n;) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                ++j;
                ans = Math.max(ans, j - i);

            } else {
                set.remove(s.charAt(i));
                ++i;

                if (i >= n) {
                    break ;
                }
            }
        }

        return ans;
    }

    public int myAtoi(String str) {
        int p = 0;
        int result = 0;

        while (p < str.length() && Character.isWhitespace(str.charAt(p))) {
            ++p;
        }

        if (p == str.length()) {
            return 0;
        }

        boolean negFlag = str.charAt(p) == '-';

        if (str.charAt(p) == '+' || str.charAt(p) == '-') {
            ++p;
        }

        for (; p < str.length(); p++) {
            if (str.charAt(p) > '9' || str.charAt(p) < '0') {
                break;
            } else {
                int digit = str.charAt(p) - '0';
                if (!negFlag && result > (Integer.MAX_VALUE - digit)/10) {
                    return Integer.MIN_VALUE;
                }

                result = result * 10 + (negFlag ? -digit : digit);
            }

        }

        return  result;
    }

    // 求中位数，
    public double mediumSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if (m > n) {//保证 m<=n，且对应数据组数据交换
            int[] temp = A; A = B; B = temp;
/*            int tmp = m;
            m = n;
            n = tmp;*/
            m = m ^ n;
            n = m ^ n;
            m = m ^ n;
        }

        int iMin = 0, iMax = m, halfLen = (m+n+1)/2; // halfLen 两个数组长度的一半，一定小于或者等于n，因为m<=n

        while (iMin <= iMax) {// 需要考虑长度仅为 0和1 的情况
            int i = (iMin + iMax)/2;    // 第一次从长度较短的数组的中间定位
            int j = halfLen - i;    // halfLen 没有进行再次计算赋值，每一次j都会被改变，只要i在变化

            if (i < iMax && B[j-1] > A[i]) {
                iMin++;
            } else if (i > iMin && A[i-1] > B[j]) {
                iMax--;
            } else { // 只要进入这里就一定会有 返回值
                int maxLeft = 0;

                if (i == 0) {// 这种情况表明有一个是0，另一个是1
                    maxLeft = B[j-1];
                } else if (j == 0) {// 这种情况表明有一个是1，另一个是0
                    maxLeft = A[i-1];
                } else {
                    maxLeft = Math.max(A[i-1], B[j-1]);
                }

                // 这里是两个数据长度不相等，且其中一个长度是奇数
                if ((m+n)%2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0f;
            }
        }

        return 0.0f;
    }

    public static class Node {
        public int val;
        public Node next;

        public Node(int value) {
            val = value;
            next = null;
        }

        public Node merge2Lists(Node l1, Node l2) {
            if (l1 == null) {
                return l2;
            }

            if (l2 == null) {
                return l1;
            }

            if (l1.val < l2.val) {
                l1.next = merge2Lists(l1.next, l2);

                return l1;
            } else {
                l2.next = merge2Lists(l1, l2.next);

                return l2;
            }
        }

        public Node mergeLists(Node[] list) {
            Node res = list[0];
            if (list == null || list.length <= 0) {
                return null;
            } else if (list.length == 1) {
                return list[0];
            } else if (list.length == 2) {
                merge2Lists(list[1], res);
            } else {
                for (int i=1; i< list.length; i++) {
                    merge2Lists(res, list[i]);
                }
            }

            return res;
        }

        // 使用了辅助空间
        public Node merge2Lists2(Node l1, Node l2) {
            if (l1 == null) {
                return l2;
            }

            if (l2 == null) {
                return l1;
            }

            Node dummy = new Node(0);
            Node tail = dummy;
            dummy.next = null;

            while (l1 != null || l2 != null) {
                Node node = new Node(0);
                node.next = null;
                tail.next = node;
                tail = node;

                if (l1 != null) {
                    if (l2 != null) {
                        if (l1.val<l2.val) {
                            node.val = l1.val;
                            l1 = l1.next;
                        } else {
                            node.val = l2.val;
                            l2 = l2.next;
                        }
                    } else {
                        node.val = l1.val;
                        l1 = l1.next;
                    }
                } else {
                    node.val = l2.val;
                    l2 = l2.next;
                }
            }

            return dummy.next;
        }

        public boolean hasCycle(Node head) {
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }

            return false;
        }

        public boolean hasCycle2(Node head) {
            Set<Node> set = new HashSet();
            while (head != null) {
                if (!set.add(head)) {
                    return true;
                }

                head = head.next;
            }

            return false;
        }

        public Node reverseList(Node head) {
            Node h = null;
            while (head != null) {
                Node next = head.next;
                head.next = h;
                h = head;
                head = next;
            }

            return h;
        }

        public Node add2Nums(Node l1, Node l2) {
            Node dummyHead = new Node(0);
            Node cur = dummyHead;
            int cc = 0;

            while (l1 != null || l2 != null) {
                int a = (l1 != null) ? l1.val : 0;
                int b = (l2 != null) ? l2.val : 0;
                int sum = a + b + cc;
                cc = sum / 10;
                cur.next = new Node(sum % 10);
                cur = cur.next;
                if (l1.next != null) l1 = l1.next;
                if (l2.next != null) l2 = l2.next;
            }

            if (cc > 0) {
                cur.next = new Node(cc);
            }

            return dummyHead.next;
        }

        // 冒泡链表排序
        public Node sortList(Node l) {
            if (l == null || l.next == null) {
                return l;
            }

            Node head = l;
            Node tail = null;

            while (head.next != tail) {

                while (head.next != tail) {
                    if (head.val > head.next.val) {
                        int tmp = head.val;
                        head.val = head.next.val;
                        head.next.val = tmp;
                    }

                    head = head.next;
                }

                tail = head;
                head = l;
            }

            return l;
        }

    }

    // z字形排列，逐行读取
    public String zConvert(String s, int rows) {
        if (rows == 1) {
            return s;
        }

        StringBuilder ret = new StringBuilder();
        int len = s.length();
        int cycStep = 2 * rows - 2;

        for (int i=0; i< rows; i++) {
            for (int j=0; j+i<len; j+=cycStep) {
                ret.append(s.charAt(i+j));
                if (i != 0 && i != rows-1 && j+cycStep-i < len) {
                    ret.append(s.charAt(j+cycStep-i));
                }
            }

        }

        return ret.toString();
    }

    public int maxArea(int height[]) {
        int area = 0;

        for (int i =0; i < height.length; i++) {
            int area1 = 0;
            for (int j=i+1; j<height.length; j++) {
                int tmpArea = (j-i)*Math.min(height[i],height[j]);
                area1 = Math.max(area1, tmpArea);
            }

            area = Math.max(area, area1);
        }

        return area;
    }

    public int maxArea2(int height[]) {
        int area = (height.length - 1)*Math.min(height[0], height[height.length-1]);
        int i = 0;
        int j = height.length-1;

        while (i<j) {
            area = Math.max(area, (j-i)*Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return area;
    }

    public boolean isVaildSymbol(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{') {
                stack.push(tmp);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char c = stack.peek();
                    if (c == '(' && tmp != ')') {
                        return false;
                    } else if (c == '{' && tmp != '}') {
                        return false;
                    } else if (c == '[' && tmp != ']') {
                        return false;
                    }

                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public int roman2Int(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i=0; i<s.length();i++) {
            if (i>0 && map.get(s.charAt(i)) > map.get(s.charAt(i-1))) {
                result += map.get(s.charAt(i)) - 2*map.get(s.charAt(i-1));
            } else {
                result += map.get(s.charAt(i));
            }
        }

        return result;
    }

    public String Int2Roman(int n) {
        String[] I = {"","I","II","III","IV","VI","VII","VIII","IX"};
        String[] X = {"","X","XX","XXX","XL","L","LX","XLL","XLLL","XC"};
        String[] C = {"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] M = {"", "M","MM","MMM"};

        String result = M[n/1000] + C[n%1000/100] + X[n%100/10] + I[n%10];

        return result;
    }

    public String reverseString(String s) {
        if (s == null || s.length() <= 0) {
            return null;
        }

        int i = 0;
        int j = s.length() - 1;

        char[] arr = s.toCharArray();
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

            i++;
            j--;
        }

        return  new String(arr);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length;i++) {
            int tmp = target - nums[i];
//            if (map.containsKey(tmp)) {
            if (map.containsKey(tmp)) {
                return new int[] {i, map.get(tmp)};
            }
        }

        return null;
    }

    // 回文数
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        }

        int reversed = 0;
        int x1 = x;
        while (x1>reversed) {
            int digit = x1 % 10; // 每一次求x的个位数
            reversed *= 10; // 每一次先×10进一位
            reversed += digit;  // 累加个位数
            x1 /= 10; // x 减小 一位数
        }

//        return x == reversed || x == reversed/10;
        return x == reversed;
    }

    public int findKthLargest(int[] nums, int k) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int i : nums) {
                maxHeap.offer(i);
            }

            while (k > 1) {
                maxHeap.poll();
                k--;
            }

            return maxHeap.poll();
        }

        return 0;
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int dymIntegerSplit(int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++ ){
                if(i == 1 || j == 1){
                    dp[i][j] = 1;
                }else if (i == j) {
                    dp[i][j] = 1 + dp[i][j - 1];
                }else if (i < j) {
                    dp[i][j] = dp[i][i];
                }else {
                    dp[i][j] = dp[i - j][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int integerBreak(int n) {

        if (n == 2){
            return 1;
        }else if (n == 3){
            return 2;
        }
        int[] max = new int[n+1];
        max[1] = 1;
        max[2] = 2;
        max[3] = 3;
        int ans = 0;
        for (int i = 4; i <= n; i++){
            ans = 0;
            for (int j = 1; j <= i/2 + 1; j++){
                Log.d(TAG, "i = " + i + ", j = " + j + ", max[j] = " + max[j] + ", max[i-j] = " + max[i-j]);
                int cur = max[j] * max[i-j];
                if (ans < cur){
                    ans = cur;
                    max[i] = ans;
                }

            }
        }

        ans = max[n];

        for (int i=0;i<n+1;i++) {
            Log.d(TAG, "max[" + i + "]" + " = " + max[i]);
        }
        return ans;
    }

    public int integerBreak2(int n) {

        if (n == 2){
            return 1;
        }else if (n == 3){
            return 2;
        }
        int[] max = new int[n+1];
/*        max[1] = 1;
        max[2] = 2;
        max[3] = 3;*/
        int ans = 0;
//        for (int i = 4; i <= n; i++){
//            ans = 0;
        int j = 1;
            for (; j <= n/2 + 1; j++){
                Log.d(TAG, "n = " + n + ", j = " + j + ", n - j = " + (n-j));
                int cur = j * (n-j);
                if (ans < cur){
                    ans = cur;
                    max[j] = ans;
                }

            }
//        }

//        ans = max[j];

        for (int i=0;i<n+1;i++) {
            Log.d(TAG, "max[" + i + "]" + " = " + max[i]);
        }
        return ans;
    }

    public int integerBreak3(int n) {
        if (n == 2){
            return 1;
        } else if (n == 3){
            return 2;
        } else if (n % 3 == 0) {
            return (int) Math.pow(3, n/3);
        } else if (n % 3 == 1) {
            return 2*2*(int)Math.pow(3,(n-4)/3);
        } else {
            return 2*(int)Math.pow(3,n/3);
        }
    }

    // 求众数，利用桶高确定数量大小进行比较
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int maxElements(int[] nums) {
        Map<Integer, Integer> bucket = new HashMap<>();

        for (int i : nums) {
            bucket.put(i, bucket.getOrDefault(i, 0) + 1);
            if (bucket.get(i) >= nums.length/2) {
                return i;
            }
        }

        return -1;
    }

    public int binarySearch(int[] array,int fromIndex,int toIndex,int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if (key < mid) {
                high = mid -1;
            } else if (key > mid) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -(low + 1); //low+1表示找不到时停在了第low+1个元素的位置
    }

    // 螺旋矩阵
    public static class SpiralMatrix {

        /**
         * @param n n阶
         * @return
         */
        public int[][] createMatrix(int n)
        {
            int[][] matrix = new int[n][n];//n*n的二维数组，初始元素值都为0
            int right = 1, down = 2, left = 3, up = 4;//分别表示右下左上四个方向
            int direction = right;

            int numb = n * n;//n阶矩阵，共有n×n个数
            int i = 0, j = 0;
            for (int p = 1; p <= numb; p++)
            {
                matrix[i][j] = p;
                //判断方向向右的情况
                if(direction == right)
                {
                    //如果当前位置的右面位置在右边界内且值还是初始值，则行不变，列号向右移动一位
                    if (j + 1 < n && matrix[i][j + 1] == 0)
                    {
                        j++;
                    } else {//如果超出右边边界，或者右面的元素已经被修改过，则向下移动一行，且将方向改为向下
                        i++;
                        direction = down;
                        continue;
                    }
                }
                //判断方向向下的情况
                if (direction == down)
                {
                    //如果当前位置的下面位置在下边界内且值还是初始值，则列不变，行号向下移动一位
                    if (i + 1 < n && matrix[i + 1][j] == 0)
                    {
                        i++;
                    } else {//如果超出下边界，或者下面的元素已经被修改过，则向左移动一行，且将方向改为向左
                        j--;
                        direction = left;
                        continue;
                    }
                }
                //判断方向向左的情况
                if (direction == left)
                {
                    //如果当前位置的左面位置在左边界内且值还是初始值，则行不变，列号向左移动一位
                    if (j - 1 >= 0 && matrix[i][j - 1] == 0)
                    {
                        j--;
                    } else {//如果超出左边界，或者左面的元素已经被修改过，则向上移动一行，且将方向改为向上
                        i--;
                        direction = up;
                        continue;
                    }
                }
                //判断方向向上的情况
                if (direction == up)
                {
                    //如果当前位置的上面位置在上边界内且值还是初始值，则列不变，行号向左移动一位
                    if (i - 1 >= 0 && matrix[i - 1][j] == 0)
                    {
                        i--;
                    } else {//如果超出上边界，或者上面的元素已经被修改过，则向右移动一列，且将方向改为向右
                        j++;
                        direction = right;
                        continue;
                    }
                }
            }
            return matrix;
        }

        /**
         * 测试
         * @param args
         */
        public static void main(String[] args) {
            int n = 10;
            SpiralMatrix s = new SpiralMatrix();
            int[][] data = s.createMatrix(n);
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
            }
        }

        // 三数之和 最接近的数
        public int threeSumClosest(int[] nums, int target) {
            if(nums.length == 0){
                return 0;
            }
            Arrays.sort(nums);
            int closenum = 0;
            int tp = Integer.MAX_VALUE;
            for(int i = 0;i < nums.length - 2;i++){
                int pre = i + 1;
                int tail = nums.length - 1;
                while(pre < tail){
                    int tmp = nums[i] + nums[pre] + nums[tail];
                    int x = Math.abs(tmp - target);
                    if(tmp < tp){
                        closenum = tmp;
                        tp = x;
                    }
                    if(tp < target){
                        pre++;
                    }else if(tp > target){
                        tail--;
                    }else{
                        return tmp;
                    }
                }
            }
            return closenum;
        }
    }

    public void testBox() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 6;
        Integer d = 6;
        Integer e = -129;
        Integer f = -129;
        Long g = 3L;
        Long h = 2L;
/*        Integer a = 1;
        Integer a = 1;
        Integer a = 1;
        Integer a = 1;*/

        Log.d(TAG, "c==d :" + (c==d));
        Log.d(TAG, "e==f :" + (e==f));
        Log.d(TAG, "c==(a+b) :" + (c==(a+b)));
        Log.d(TAG, "c.equals(a+b) :" + (c.equals(a+b)));
        Log.d(TAG, "g==(a+b) :" + (g==(a+b)));
        Log.d(TAG, "g.equals(a+b) :" + (g.equals(a+b)));
        Log.d(TAG, "g.equals(a+h) :" + (g.equals(a+h)));
//        Log.d(TAG, );

        Float i = 3.0f;
        Float j = 3.0f;
        Double k = 10000000000000.0d;
        Double l = 10000000000000.0d;

        Log.d(TAG, "i = " + i);
        Log.d(TAG, "k = :" + k);
        Log.d(TAG, "i==j :" + (i==j));
        Log.d(TAG, "k==l :" + (k==l));
    }
}
