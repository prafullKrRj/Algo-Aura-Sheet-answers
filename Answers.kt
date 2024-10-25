package com.prafull
data class Topic(
    val topicName: String, val topicDetails: String, val questions: List<Question>
)

data class Question(
    val name: String,
    val link: String,
    val solved: Boolean = false,
    val revision: Boolean = false,
    val note: String = "",
    val solutionJava: String = "",
    val solutionCpp: String = "",
)
val leetcodeDSATopics = listOf(
    Topic(
        topicName = "Learn the Basics",
        topicDetails = "Fundamental problems to get started with DSA",
        questions = listOf(
            Question(
                name = "Two Sum",
                link = "https://leetcode.com/problems/two-sum/",
                solutionJava = """
                ```java
                class Solution {
                    public int[] twoSum(int[] nums, int target) {
                        HashMap<Integer, Integer> map = new HashMap<>();
                        for (int i = 0; i < nums.length; i++) {
                            int complement = target - nums[i];
                            if (map.containsKey(complement)) {
                                return new int[] { map.get(complement), i };
                            }
                            map.put(nums[i], i);
                        }
                        throw new IllegalArgumentException("No two sum solution");
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    vector<int> twoSum(vector<int>& nums, int target) {
                        unordered_map<int, int> map;
                        for (int i = 0; i < nums.size(); i++) {
                            int complement = target - nums[i];
                            if (map.find(complement) != map.end()) {
                                return { map[complement], i };
                            }
                            map[nums[i]] = i;
                        }
                        throw invalid_argument("No two sum solution");
                    }
                };
                ```""",
            ),
            Question(
                name = "Reverse String",
                link = "https://leetcode.com/problems/reverse-string/",
                solutionJava = """
                ```java
                class Solution {
                    public void reverseString(char[] s) {
                        int left = 0, right = s.length - 1;
                        while (left < right) {
                            char temp = s[left];
                            s[left] = s[right];
                            s[right] = temp;
                            left++;
                            right--;
                        }
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    void reverseString(vector<char>& s) {
                        int left = 0, right = s.size() - 1;
                        while (left < right) {
                            swap(s[left], s[right]);
                            left++;
                            right--;
                        }
                    }
                };
                ```""",
            ),
            Question(
                name = "Fizz Buzz",
                link = "https://leetcode.com/problems/fizz-buzz/",
                solutionJava = """
                ```java
                class Solution {
                    public List<String> fizzBuzz(int n) {
                        List<String> result = new ArrayList<>();
                        for (int i = 1; i <= n; i++) {
                            if (i % 3 == 0 && i % 5 == 0) {
                                result.add("FizzBuzz");
                            } else if (i % 3 == 0) {
                                result.add("Fizz");
                            } else if (i % 5 == 0) {
                                result.add("Buzz");
                            } else {
                                result.add(Integer.toString(i));
                            }
                        }
                        return result;
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    vector<string> fizzBuzz(int n) {
                        vector<string> result;
                        for (int i = 1; i <= n; i++) {
                            if (i % 3 == 0 && i % 5 == 0) {
                                result.push_back("FizzBuzz");
                            } else if (i % 3 == 0) {
                                result.push_back("Fizz");
                            } else if (i % 5 == 0) {
                                result.push_back("Buzz");
                            } else {
                                result.push_back(to_string(i));
                            }
                        }
                        return result;
                    }
                };
                ```""",
            ),
            Question(
                name = "Palindrome Number",
                link = "https://leetcode.com/problems/palindrome-number/",
                solutionJava = """
                ```java
                class Solution {
                    public boolean isPalindrome(int x) {
                        if (x < 0) return false;
                        int original = x, reversed = 0;
                        while (x > 0) {
                            reversed = reversed * 10 + x % 10;
                            x /= 10;
                        }
                        return original == reversed;
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    bool isPalindrome(int x) {
                        if (x < 0) return false;
                        int original = x, reversed = 0;
                        while (x > 0) {
                            reversed = reversed * 10 + x % 10;
                            x /= 10;
                        }
                        return original == reversed;
                    }
                };
                ```""",
            ),
            Question(
                name = "Roman to Integer",
                link = "https://leetcode.com/problems/roman-to-integer/",
                solutionJava = """
                ```java
                class Solution {
                    public int romanToInt(String s) {
                        Map<Character, Integer> map = new HashMap<>();
                        map.put('I', 1);
                        map.put('V', 5);
                        map.put('X', 10);
                        map.put('L', 50);
                        map.put('C', 100);
                        map.put('D', 500);
                        map.put('M', 1000);
                        int total = 0, prevValue = 0;
                        for (char c : s.toCharArray()) {
                            int value = map.get(c);
                            total += value;
                            if (value > prevValue) {
                                total -= 2 * prevValue;
                            }
                            prevValue = value;
                        }
                        return total;
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    int romanToInt(string s) {
                        unordered_map<char, int> map = {
                            {'I', 1}, {'V', 5}, {'X', 10},
                            {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}
                        };
                        int total = 0, prevValue = 0;
                        for (char c : s) {
                            int value = map[c];
                            total += value;
                            if (value > prevValue) {
                                total -= 2 * prevValue;
                            }
                            prevValue = value;
                        }
                        return total;
                    }
                };
                ```""",
            ),
            Question(
                name = "Maximum Subarray",
                link = "https://leetcode.com/problems/maximum-subarray/",
                solutionJava = """
                ```java
                class Solution {
                    public int maxSubArray(int[] nums) {
                        int maxSoFar = nums[0], maxEndingHere = nums[0];
                        for (int i = 1; i < nums.length; i++) {
                            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
                            maxSoFar = Math.max(maxSoFar, maxEndingHere);
                        }
                        return maxSoFar;
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    int maxSubArray(vector<int>& nums) {
                        int maxSoFar = nums[0], maxEndingHere = nums[0];
                        for (int i = 1; i < nums.size(); i++) {
                            maxEndingHere = max(nums[i], maxEndingHere + nums[i]);
                            maxSoFar = max(maxSoFar, maxEndingHere);
                        }
                        return maxSoFar;
                    }
                };
                ```""",
            ),
            Question(
                name = "Move Zeroes",
                link = "https://leetcode.com/problems/move-zeroes/",
                solutionJava = """
                ```java
                class Solution {
                    public void moveZeroes(int[] nums) {
                        int lastNonZeroFoundAt = 0;
                        for (int i = 0; i < nums.length; i++) {
                            if (nums[i] != 0) {
                                nums[lastNonZeroFoundAt++] = nums[i];
                            }
                        }
                        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
                            nums[i] = 0;
                        }
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    void moveZeroes(vector<int>& nums) {
                        int lastNonZeroFoundAt = 0;
                        for (int i = 0; i < nums.size(); i++) {
                            if (nums[i] != 0) {
                                nums[lastNonZeroFoundAt++] = nums[i];
                            }
                        }
                        for (int i = lastNonZeroFoundAt; i < nums.size(); i++) {
                            nums[i] = 0;
                        }
                    }
                };
                ```""",
            ),
            Question(
                name = "Valid Anagram",
                link = "https://leetcode.com/problems/valid-anagram/",
                solutionJava = """
        ```java
        class Solution {
            public boolean isAnagram(String s, String t) {
                if (s.length() != t.length()) return false;
                int[] count = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    count[s.charAt(i) - 'a']++;
                    count[t.charAt(i) - 'a']--;
                }
                for (int i : count) {
                    if (i != 0) return false;
                }
                return true;
            }
        }
        ```""",
                solutionCpp = """
        ```cpp
        class Solution {
        public:
            bool isAnagram(string s, string t) {
                if (s.size() != t.size()) return false;
                vector<int> count(26, 0);
                for (int i = 0; i < s.size(); i++) {
                    count[s[i] - 'a']++;
                    count[t[i] - 'a']--;
                }
                for (int i : count) {
                    if (i != 0) return false;
                }
                return true;
            }
        };
        ```""",
            ),
            Question(
                name = "Contains Duplicate",
                link = "https://leetcode.com/problems/contains-duplicate/",
                solutionJava = """
                ```java
                class Solution {
                    public boolean containsDuplicate(int[] nums) {
                        Set<Integer> set = new HashSet<>();
                        for (int num : nums) {
                            if (!set.add(num)) return true;
                        }
                        return false;
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    bool containsDuplicate(vector<int>& nums) {
                        unordered_set<int> set;
                        for (int num : nums) {
                            if (!set.insert(num).second) return true;
                        }
                        return false;
                    }
                };
                ```""",
            ),
            Question(
                name = "Single Number",
                link = "https://leetcode.com/problems/single-number/",
                solutionJava = """
                ```java
                class Solution {
                    public int singleNumber(int[] nums) {
                        int result = 0;
                        for (int num : nums) {
                            result ^= num;
                        }
                        return result;
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    int singleNumber(vector<int>& nums) {
                        int result = 0;
                        for (int num : nums) {
                            result ^= num;
                        }
                        return result;
                    }
                };
                ```""",
            ),
            Question(
                name = "Plus One",
                link = "https://leetcode.com/problems/plus-one/",
                solutionJava = """
                ```java
                class Solution {
                    public int[] plusOne(int[] digits) {
                        for (int i = digits.length - 1; i >= 0; i--) {
                            if (digits[i] < 9) {
                                digits[i]++;
                                return digits;
                            }
                            digits[i] = 0;
                        }
                        int[] result = new int[digits.length + 1];
                        result[0] = 1;
                        return result;
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    vector<int> plusOne(vector<int>& digits) {
                        for (int i = digits.size() - 1; i >= 0; i--) {
                            if (digits[i] < 9) {
                                digits[i]++;
                                return digits;
                            }
                            digits[i] = 0;
                        }
                        digits.insert(digits.begin(), 1);
                        return digits;
                    }
                };
                ```""",
            ),
            Question(
                name = "Intersection of Two Arrays II",
                link = "https://leetcode.com/problems/intersection-of-two-arrays-ii/",
                solutionJava = """
                ```java
                class Solution {
                    public int[] intersect(int[] nums1, int[] nums2) {
                        Map<Integer, Integer> map = new HashMap<>();
                        for (int num : nums1) {
                            map.put(num, map.getOrDefault(num, 0) + 1);
                        }
                        List<Integer> result = new ArrayList<>();
                        for (int num : nums2) {
                            if (map.getOrDefault(num, 0) > 0) {
                                result.add(num);
                                map.put(num, map.get(num) - 1);
                            }
                        }
                        return result.stream().mapToInt(i -> i).toArray();
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
                        unordered_map<int, int> map;
                        for (int num : nums1) {
                            map[num]++;
                        }
                        vector<int> result;
                        for (int num : nums2) {
                            if (map[num] > 0) {
                                result.push_back(num);
                                map[num]--;
                            }
                        }
                        return result;
                    }
                };
                ```""",
            ),
            Question(
                name = "Best Time to Buy and Sell Stock",
                link = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/",
                solutionJava = """
                ```java
                class Solution {
                    public int maxProfit(int[] prices) {
                        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
                        for (int price : prices) {
                            if (price < minPrice) {
                                minPrice = price;
                            } else {
                                maxProfit = Math.max(maxProfit, price - minPrice);
                            }
                        }
                        return maxProfit;
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    int maxProfit(vector<int>& prices) {
                        int minPrice = INT_MAX, maxProfit = 0;
                        for (int price : prices) {
                            if (price < minPrice) {
                                minPrice = price;
                            } else {
                                maxProfit = max(maxProfit, price - minPrice);
                            }
                        }
                        return maxProfit;
                    }
                };
                ```""",
            ),
            Question(
                name = "Valid Parentheses",
                link = "https://leetcode.com/problems/valid-parentheses/",
                solutionJava = """
                ```java
                class Solution {
                    public boolean isValid(String s) {
                        Stack<Character> stack = new Stack<>();
                        for (char c : s.toCharArray()) {
                            if (c == '(') stack.push(')');
                            else if (c == '{') stack.push('}');
                            else if (c == '[') stack.push(']');
                            else if (stack.isEmpty() || stack.pop() != c) return false;
                        }
                        return stack.isEmpty();
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    bool isValid(string s) {
                        stack<char> stack;
                        for (char c : s) {
                            if (c == '(') stack.push(')');
                            else if (c == '{') stack.push('}');
                            else if (c == '[') stack.push(']');
                            else if (stack.empty() || stack.top() != c) return false;
                            else stack.pop();
                        }
                        return stack.empty();
                    }
                };
                ```""",
            ),
            Question(
                name = "Missing Number",
                link = "https://leetcode.com/problems/missing-number/",
                solutionJava = """
                ```java
                class Solution {
                    public int missingNumber(int[] nums) {
                        int sum = nums.length * (nums.length + 1) / 2;
                        for (int num : nums) {
                            sum -= num;
                        }
                        return sum;
                    }
                }
                ```""",
                solutionCpp = """
                ```cpp
                class Solution {
                public:
                    int missingNumber(vector<int>& nums) {
                        int sum = nums.size() * (nums.size() + 1) / 2;
                        for (int num : nums) {
                            sum -= num;
                        }
                        return sum;
                    }
                };
                ```""",
            )
        ) // done
    ),
    Topic(
        topicName = "Learn Important Sorting Techniques",
        topicDetails = "Various sorting algorithms and their applications",
        questions = listOf(
            Question(
                name = "Sort an Array",
                link = "https://leetcode.com/problems/sort-an-array/",
                solutionJava = """
            public int[] sortArray(int[] nums) {
                Arrays.sort(nums);
                return nums;
            }
        """.trimIndent(),
                solutionCpp = """
            vector<int> sortArray(vector<int>& nums) {
                sort(nums.begin(), nums.end());
                return nums;
            }
        """.trimIndent()
            ),
            Question(
                name = "Sort Colors",
                link = "https://leetcode.com/problems/sort-colors/",
                solutionJava = """
            public void sortColors(int[] nums) {
                int count0 = 0, count1 = 0, count2 = 0;
                for (int num : nums) {
                    if (num == 0) count0++;
                    else if (num == 1) count1++;
                    else count2++;
                }
                Arrays.fill(nums, 0, count0, 0);
                Arrays.fill(nums, count0, count0 + count1, 1);
                Arrays.fill(nums, count0 + count1, nums.length, 2);
            }
        """.trimIndent(),
                solutionCpp = """
            void sortColors(vector<int>& nums) {
                int count[3] = {0};
                for (int num : nums) count[num]++;
                for (int i = 0; i < count[0]; i++) nums[i] = 0;
                for (int i = count[0]; i < count[0] + count[1]; i++) nums[i] = 1;
                for (int i = count[0] + count[1]; i < nums.size(); i++) nums[i] = 2;
            }
        """.trimIndent()
            ),
            Question(
                name = "Insertion Sort List",
                link = "https://leetcode.com/problems/insertion-sort-list/",
                solutionJava = """
            public ListNode insertionSortList(ListNode head) {
                ListNode dummy = new ListNode(0);
                while (head != null) {
                    ListNode prev = dummy;
                    while (prev.next != null && prev.next.val < head.val) {
                        prev = prev.next;
                    }
                    ListNode next = head.next;
                    head.next = prev.next;
                    prev.next = head;
                    head = next;
                }
                return dummy.next;
            }
        """.trimIndent(),
                solutionCpp = """
            ListNode* insertionSortList(ListNode* head) {
                ListNode* dummy = new ListNode(0);
                while (head) {
                    ListNode* prev = dummy;
                    while (prev->next && prev->next->val < head->val) {
                        prev = prev->next;
                    }
                    ListNode* next = head->next;
                    head->next = prev->next;
                    prev->next = head;
                    head = next;
                }
                return dummy->next;
            }
        """.trimIndent()
            ),
            Question(
                name = "Merge Intervals",
                link = "https://leetcode.com/problems/merge-intervals/",
                solutionJava = """
            public int[][] merge(int[][] intervals) {
                Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
                List<int[]> merged = new ArrayList<>();
                for (int[] interval : intervals) {
                    if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                        merged.add(interval);
                    } else {
                        merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
                    }
                }
                return merged.toArray(new int[merged.size()][]);
            }
        """.trimIndent(),
                solutionCpp = """
            vector<vector<int>> merge(vector<vector<int>>& intervals) {
                sort(intervals.begin(), intervals.end());
                vector<vector<int>> merged;
                for (const auto& interval : intervals) {
                    if (merged.empty() || merged.back()[1] < interval[0]) {
                        merged.push_back(interval);
                    } else {
                        merged.back()[1] = max(merged.back()[1], interval[1]);
                    }
                }
                return merged;
            }
        """.trimIndent()
            ),
            Question(
                name = "Maximum Gap",
                link = "https://leetcode.com/problems/maximum-gap/",
                solutionJava = """
            public int maximumGap(int[] nums) {
                if (nums.length < 2) return 0;
                Arrays.sort(nums);
                int maxGap = 0;
                for (int i = 1; i < nums.length; i++) {
                    maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
                }
                return maxGap;
            }
        """.trimIndent(),
                solutionCpp = """
            int maximumGap(vector<int>& nums) {
                if (nums.size() < 2) return 0;
                sort(nums.begin(), nums.end());
                int maxGap = 0;
                for (int i = 1; i < nums.size(); i++) {
                    maxGap = max(maxGap, nums[i] - nums[i - 1]);
                }
                return maxGap;
            }
        """.trimIndent()
            ),
            Question(
                name = "Largest Number",
                link = "https://leetcode.com/problems/largest-number/",
                solutionJava = """
            public String largestNumber(int[] nums) {
                String[] strs = new String[nums.length];
                for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
                Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
                if (strs[0].equals("0")) return "0";
                StringBuilder sb = new StringBuilder();
                for (String str : strs) sb.append(str);
                return sb.toString();
            }
        """.trimIndent(),
                solutionCpp = """
            string largestNumber(vector<int>& nums) {
                vector<string> strs(nums.size());
                for (int i = 0; i < nums.size(); i++) strs[i] = to_string(nums[i]);
                sort(strs.begin(), strs.end(), [](const string& a, const string& b) {
                    return a + b > b + a;
                });
                if (strs[0] == "0") return "0";
                string result;
                for (const auto& str : strs) result += str;
                return result;
            }
        """.trimIndent()
            ),
            Question(
                name = "Kth Largest Element in an Array",
                link = "https://leetcode.com/problems/kth-largest-element-in-an-array/",
                solutionJava = """
            public int findKthLargest(int[] nums, int k) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int num : nums) {
                    pq.add(num);
                    if (pq.size() > k) pq.poll();
                }
                return pq.poll();
            }
        """.trimIndent(),
                solutionCpp = """
            int findKthLargest(vector<int>& nums, int k) {
                priority_queue<int, vector<int>, greater<int>> pq;
                for (int num : nums) {
                    pq.push(num);
                    if (pq.size() > k) pq.pop();
                }
                return pq.top();
            }
        """.trimIndent()
            ),
            Question(
                name = "Find the Kth Largest Integer in the Array",
                link = "https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/",
                solutionJava = """
            public String kthLargestNumber(String[] nums, int k) {
                Arrays.sort(nums, (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
                return nums[nums.length - k];
            }
        """.trimIndent(),
                solutionCpp = """
            string kthLargestNumber(vector<string>& nums, int k) {
                sort(nums.begin(), nums.end(), [](const string& a, const string& b) {
                    return a.length() == b.length() ? a < b : a.length() < b.length();
                });
                return nums[nums.size() - k];
            }
        """.trimIndent()
            ),
            Question(
                name = "Sort Characters By Frequency",
                link = "https://leetcode.com/problems/sort-characters-by-frequency/",
                solutionJava = """
            public String frequencySort(String s) {
                Map<Character, Integer> countMap = new HashMap<>();
                for (char c : s.toCharArray()) countMap.put(c, countMap.getOrDefault(c, 0) + 1);
                List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(countMap.entrySet());
                entryList.sort((a, b) -> b.getValue() - a.getValue());
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<Character, Integer> entry : entryList) {
                    for (int i = 0; i < entry.getValue(); i++) sb.append(entry.getKey());
                }
                return sb.toString();
            }
        """.trimIndent(),
                solutionCpp = """
            string frequencySort(string s) {
                unordered_map<char, int> countMap;
                for (char c : s) countMap[c]++;
                priority_queue<pair<int, char>> pq;
                for (const auto& pair : countMap) pq.push({pair.second, pair.first});
                string result;
                while (!pq.empty()) {
                    auto [freq, ch] = pq.top();
                    pq.pop();
                    result.append(freq, ch);
                }
                return result;
            }
        """.trimIndent()
            ),
            Question(
                name = "Sort List",
                link = "https://leetcode.com/problems/sort-list/",
                solutionJava = """
            public ListNode sortList(ListNode head) {
                if (head == null || head.next == null) return head;
                ListNode mid = getMid(head);
                ListNode left = sortList(head);
                ListNode right = sortList(mid);
                return merge(left, right);
            }

            private ListNode getMid(ListNode head) {
                ListNode slow = head, fast = head;
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }
                ListNode mid = slow.next;
                slow.next = null;
                return mid;
            }

            private ListNode merge(ListNode left, ListNode right) {
                ListNode dummy = new ListNode(0);
                ListNode current = dummy;
                while (left != null && right != null) {
                    if (left.val < right.val) {
                        current.next = left;
                        left = left.next;
                    } else {
                        current.next = right;
                        right = right.next;
                    }
                    current = current.next;
                }
                current.next = left != null ? left : right;
                return dummy.next;
            }
        """.trimIndent(),
                solutionCpp = """
            ListNode* sortList(ListNode* head) {
                if (!head || !head->next) return head;
                ListNode* mid = getMid(head);
                ListNode* left = sortList(head);
                ListNode* right = sortList(mid);
                return merge(left, right);
            }

            ListNode* getMid(ListNode* head) {
                ListNode* slow = head, *fast = head;
                while (fast && fast->next) {
                    slow = slow->next;
                    fast = fast->next->next;
                }
                ListNode* mid = slow->next;
                slow->next = nullptr;
                return mid;
            }

            ListNode* merge(ListNode* left, ListNode* right) {
                ListNode dummy(0);
                ListNode* current = &dummy;
                while (left && right) {
                    if (left->val < right->val) {
                        current->next = left;
                        left = left->next;
                    } else {
                        current->next = right;
                        right = right->next;
                    }
                    current = current->next;
                }
                current->next = left ? left : right;
                return dummy.next;
            }
        """.trimIndent()
            ),
            Question(
                name = "Pancake Sorting",
                link = "https://leetcode.com/problems/pancake-sorting/",
                solutionJava = """
            public List<Integer> pancakeSort(int[] arr) {
                List<Integer> result = new ArrayList<>();
                for (int n = arr.length; n > 1; n--) {
                    int index = findMaxIndex(arr, n);
                    if (index != n - 1) {
                        if (index != 0) {
                            result.add(index + 1);
                            flip(arr, index + 1);
                        }
                        result.add(n);
                        flip(arr, n);
                    }
                }
                return result;
            }

            private int findMaxIndex(int[] arr, int n) {
                int maxIndex = 0;
                for (int i = 1; i < n; i++) {
                    if (arr[i] > arr[maxIndex]) maxIndex = i;
                }
                return maxIndex;
            }

            private void flip(int[] arr, int k) {
                int left = 0, right = k - 1;
                while (left < right) {
                    int temp = arr[left];
                    arr[left++] = arr[right];
                    arr[right--] = temp;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            vector<int> pancakeSort(vector<int>& arr) {
                vector<int> result;
                for (int n = arr.size(); n > 1; n--) {
                    int index = findMaxIndex(arr, n);
                    if (index != n - 1) {
                        if (index != 0) {
                            result.push_back(index + 1);
                            flip(arr, index + 1);
                        }
                        result.push_back(n);
                        flip(arr, n);
                    }
                }
                return result;
            }

            int findMaxIndex(vector<int>& arr, int n) {
                int maxIndex = 0;
                for (int i = 1; i < n; i++) {
                    if (arr[i] > arr[maxIndex]) maxIndex = i;
                }
                return maxIndex;
            }

            void flip(vector<int>& arr, int k) {
                reverse(arr.begin(), arr.begin() + k);
            }
        """.trimIndent()
            ),
            Question(
                name = "Relative Sort Array",
                link = "https://leetcode.com/problems/relative-sort-array/",
                solutionJava = """
            public int[] relativeSortArray(int[] arr1, int[] arr2) {
                Map<Integer, Integer> countMap = new HashMap<>();
                for (int num : arr1) countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                int index = 0;
                for (int num : arr2) {
                    for (int i = 0; i < countMap.get(num); i++) {
                        arr1[index++] = num;
                    }
                    countMap.remove(num);
                }
                List<Integer> remaining = new ArrayList<>(countMap.keySet());
                Collections.sort(remaining);
                for (int num : remaining) {
                    for (int i = 0; i < countMap.get(num); i++) {
                        arr1[index++] = num;
                    }
                }
                return arr1;
            }
        """.trimIndent(),
                solutionCpp = """
            vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
                unordered_map<int, int> countMap;
                for (int num : arr1) countMap[num]++;
                vector<int> result;
                for (int num : arr2) {
                    result.insert(result.end(), countMap[num], num);
                    countMap.erase(num);
                }
                vector<int> remaining;
                for (const auto& pair : countMap) {
                    remaining.insert(remaining.end(), pair.first, pair.second);
                }
                sort(remaining.begin(), remaining.end());
                result.insert(result.end(), remaining.begin(), remaining.end());
                return result;
            }
        """.trimIndent()
            ),
            Question(
                name = "Custom Sort String",
                link = "https://leetcode.com/problems/custom-sort-string/",
                solutionJava = """
            public String customSortString(String order, String s) {
                int[] count = new int[26];
                for (char c : s.toCharArray()) count[c - 'a']++;
                StringBuilder sb = new StringBuilder();
                for (char c : order.toCharArray()) {
                    while (count[c - 'a']-- > 0) sb.append(c);
                }
                for (char c = 'a'; c <= 'z'; c++) {
                    while (count[c - 'a']-- > 0) sb.append(c);
                }
                return sb.toString();
            }
        """.trimIndent(),
                solutionCpp = """
            string customSortString(string order, string s) {
                vector<int> count(26, 0);
                for (char c : s) count[c - 'a']++;
                string result;
                for (char c : order) {
                    result.append(count[c - 'a'], c);
                    count[c - 'a'] = 0;
                }
                for (char c = 'a'; c <= 'z'; c++) {
                    result.append(count[c - 'a'], c);
                }
                return result;
            }
        """.trimIndent()
            ),
            Question(
                name = "Sort Array by Increasing Frequency",
                link = "https://leetcode.com/problems/sort-array-by-increasing-frequency/",
                solutionJava = """
            public int[] frequencySort(int[] nums) {
                Map<Integer, Integer> countMap = new HashMap<>();
                for (int num : nums) countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
                entryList.sort((a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : a.getValue() - b.getValue());
                int index = 0;
                for (Map.Entry<Integer, Integer> entry : entryList) {
                    for (int i = 0; i < entry.getValue(); i++) {
                        nums[index++] = entry.getKey();
                    }
                }
                return nums;
            }
        """.trimIndent(),
                solutionCpp = """
            vector<int> frequencySort(vector<int>& nums) {
                unordered_map<int, int> countMap;
                for (int num : nums) countMap[num]++;
                vector<pair<int, int>> entryList(countMap.begin(), countMap.end());
                sort(entryList.begin(), entryList.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
                    return a.second == b.second ? a.first < b.first : a.second < b.second;
                });
                vector<int> result;
                for (const auto& entry : entryList) {
                    result.insert(result.end(), entry.second, entry.first);
                }
                return result;
            }
        """.trimIndent()
            ),
            Question(
                name = "Wiggle Sort II",
                link = "https://leetcode.com/problems/wiggle-sort-ii/",
                solutionJava = """
            public void wiggleSort(int[] nums) {
                int n = nums.length;
                int[] copy = Arrays.copyOf(nums, n);
                Arrays.sort(copy);
                int mid = (n + 1) / 2;
                int j = mid, k = n - 1;
                for (int i = 0; i < n; i++) {
                    nums[i] = (i % 2 == 0) ? copy[--j] : copy[k--];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            void wiggleSort(vector<int>& nums) {
                int n = nums.size();
                vector<int> copy(nums);
                sort(copy.begin(), copy.end());
                int mid = (n + 1) / 2;
                int j = mid - 1, k = n - 1;
                for (int i = 0; i < n; i++) {
                    nums[i] = (i % 2 == 0) ? copy[j--] : copy[k--];
                }
            }
        """.trimIndent()
            )
        ) // done
    ), Topic(
        topicName = "Arrays",
        topicDetails = "Problems focused on array manipulation and algorithms",
        questions = listOf(
            Question(
                name = "Two Sum",
                link = "https://leetcode.com/problems/two-sum/",
                solutionJava = """
                ```java
                // Class: TwoSumSolution
                class TwoSumSolution {
                    public int[] twoSum(int[] nums, int target) {
                        Map<Integer, Integer> map = new HashMap<>();
                        for (int i = 0; i < nums.length; i++) {
                            int complement = target - nums[i];
                            if (map.containsKey(complement)) {
                                return new int[] { map.get(complement), i };
                            }
                            map.put(nums[i], i);
                        }
                        throw new IllegalArgumentException("No solution found");
                    }
                }
                ```
            """,
                solutionCpp = """
                ```cpp
                // Class: TwoSumSolution
                #include <unordered_map>
                class TwoSumSolution {
                public:
                    vector<int> twoSum(vector<int>& nums, int target) {
                        unordered_map<int, int> map;
                        for (int i = 0; i < nums.size(); i++) {
                            int complement = target - nums[i];
                            if (map.find(complement) != map.end()) {
                                return { map[complement], i };
                            }
                            map[nums[i]] = i;
                        }
                        return {};
                    }
                };
                ```
            """
            ),
            Question(
                name = "Best Time to Buy and Sell Stock",
                link = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/",
                solutionJava = """
                ```java
                // Class: MaxProfitSolution
                class MaxProfitSolution {
                    public int maxProfit(int[] prices) {
                        int minPrice = Integer.MAX_VALUE;
                        int maxProfit = 0;
                        for (int price : prices) {
                            if (price < minPrice) minPrice = price;
                            else maxProfit = Math.max(maxProfit, price - minPrice);
                        }
                        return maxProfit;
                    }
                }
                ```
            """,
                solutionCpp = """
                ```cpp
                // Class: MaxProfitSolution
                class MaxProfitSolution {
                public:
                    int maxProfit(vector<int>& prices) {
                        int minPrice = INT_MAX, maxProfit = 0;
                        for (int price : prices) {
                            if (price < minPrice) minPrice = price;
                            else maxProfit = max(maxProfit, price - minPrice);
                        }
                        return maxProfit;
                    }
                };
                ```
            """
            ),
            Question(
                name = "Contains Duplicate",
                link = "https://leetcode.com/problems/contains-duplicate/",
                solutionJava = """
                ```java
                // Class: ContainsDuplicateSolution
                class ContainsDuplicateSolution {
                    public boolean containsDuplicate(int[] nums) {
                        Set<Integer> set = new HashSet<>();
                        for (int num : nums) {
                            if (!set.add(num)) return true;
                        }
                        return false;
                    }
                }
                ```
            """,
                solutionCpp = """
                ```cpp
                // Class: ContainsDuplicateSolution
                class ContainsDuplicateSolution {
                public:
                    bool containsDuplicate(vector<int>& nums) {
                        unordered_set<int> set;
                        for (int num : nums) {
                            if (!set.insert(num).second) return true;
                        }
                        return false;
                    }
                };
                ```
            """
            ),
            Question(
                name = "Product of Array Except Self",
                link = "https://leetcode.com/problems/product-of-array-except-self/",
                solutionJava = """
                ```java
                // Class: ProductExceptSelfSolution
                class ProductExceptSelfSolution {
                    public int[] productExceptSelf(int[] nums) {
                        int n = nums.length;
                        int[] output = new int[n];
                        int left = 1, right = 1;
                        Arrays.fill(output, 1);
                        for (int i = 0; i < n; i++) {
                            output[i] *= left;
                            left *= nums[i];
                        }
                        for (int i = n - 1; i >= 0; i--) {
                            output[i] *= right;
                            right *= nums[i];
                        }
                        return output;
                    }
                }
                ```
            """,
                solutionCpp = """
                ```cpp
                // Class: ProductExceptSelfSolution
                class ProductExceptSelfSolution {
                public:
                    vector<int> productExceptSelf(vector<int>& nums) {
                        int n = nums.size();
                        vector<int> output(n, 1);
                        int left = 1, right = 1;
                        for (int i = 0; i < n; ++i) {
                            output[i] *= left;
                            left *= nums[i];
                        }
                        for (int i = n - 1; i >= 0; --i) {
                            output[i] *= right;
                            right *= nums[i];
                        }
                        return output;
                    }
                };
                ```
            """
            ),
            Question(
                name = "Maximum Subarray",
                link = "https://leetcode.com/problems/maximum-subarray/",
                solutionJava = """
                ```java
                // Class: MaxSubArraySolution
                class MaxSubArraySolution {
                    public int maxSubArray(int[] nums) {
                        int maxSum = nums[0], currentSum = nums[0];
                        for (int i = 1; i < nums.length; i++) {
                            currentSum = Math.max(nums[i], currentSum + nums[i]);
                            maxSum = Math.max(maxSum, currentSum);
                        }
                        return maxSum;
                    }
                }
                ```
            """,
                solutionCpp = """
                ```cpp
                // Class: MaxSubArraySolution
                class MaxSubArraySolution {
                public:
                    int maxSubArray(vector<int>& nums) {
                        int maxSum = nums[0], currentSum = nums[0];
                        for (int i = 1; i < nums.size(); ++i) {
                            currentSum = max(nums[i], currentSum + nums[i]);
                            maxSum = max(maxSum, currentSum);
                        }
                        return maxSum;
                    }
                };
                ```
            """
            ),
            Question(
                name = "Maximum Product Subarray",
                link = "https://leetcode.com/problems/maximum-product-subarray/",
                solutionJava = """
                ```java
                // Class: MaxProductSubarraySolution
                class MaxProductSubarraySolution {
                    public int maxProduct(int[] nums) {
                        int maxProduct = nums[0], minProduct = nums[0], result = nums[0];
                        for (int i = 1; i < nums.length; i++) {
                            if (nums[i] < 0) {
                                int temp = maxProduct;
                                maxProduct = minProduct;
                                minProduct = temp;
                            }
                            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
                            minProduct = Math.min(nums[i], minProduct * nums[i]);
                            result = Math.max(result, maxProduct);
                        }
                        return result;
                    }
                }
                ```
            """,
                solutionCpp = """
                ```cpp
                // Class: MaxProductSubarraySolution
                class MaxProductSubarraySolution {
                public:
                    int maxProduct(vector<int>& nums) {
                        int maxProduct = nums[0], minProduct = nums[0], result = nums[0];
                        for (int i = 1; i < nums.size(); i++) {
                            if (nums[i] < 0) swap(maxProduct, minProduct);
                            maxProduct = max(nums[i], maxProduct * nums[i]);
                            minProduct = min(nums[i], minProduct * nums[i]);
                            result = max(result, maxProduct);
                        }
                        return result;
                    }
                };
                ```
            """
            ),
            Question(
                name = "Find Minimum in Rotated Sorted Array",
                link = "https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/",
                solutionJava = """
                ```java
                // Class: FindMinInRotatedArraySolution
                class FindMinInRotatedArraySolution {
                    public int findMin(int[] nums) {
                        int left = 0, right = nums.length - 1;
                        while (left < right) {
                            int mid = left + (right - left) / 2;
                            if (nums[mid] > nums[right]) left = mid + 1;
                            else right = mid;
                        }
                        return nums[left];
                    }
                }
                ```
            """,
                solutionCpp = """
                ```cpp
                // Class: FindMinInRotatedArraySolution
                class FindMinInRotatedArraySolution {
                public:
                    int findMin(vector<int>& nums) {
                        int left = 0, right = nums.size() - 1;
                        while (left < right) {
                            int mid = left + (right - left) / 2;
                            if (nums[mid] > nums[right]) left = mid + 1;
                            else right = mid;
                        }
                        return nums[left];
                    }
                };
                ```
            """
            ),
            Question(
                name = "Search in Rotated Sorted Array",
                link = "https://leetcode.com/problems/search-in-rotated-sorted-array/",
                solutionJava = """
                ```java
                // Class: SearchInRotatedArraySolution
                class SearchInRotatedArraySolution {
                    public int search(int[] nums, int target) {
                        int left = 0, right = nums.length - 1;
                        while (left <= right) {
                            int mid = left + (right - left) / 2;
                            if (nums[mid] == target) return mid;
                            if (nums[left] <= nums[mid]) {
                                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                                else left = mid + 1;
                            } else {
                                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                                else right = mid - 1;
                            }
                        }
                        return -1;
                    }
                }
                ```
            """,
                solutionCpp = """
                ```cpp
                // Class: SearchInRotatedArraySolution
                class SearchInRotatedArraySolution {
                public:
                    int search(vector<int>& nums, int target) {
                        int left = 0, right = nums.size() - 1;
                        while (left <= right) {
                            int mid = left + (right - left) / 2;
                            if (nums[mid] == target) return mid;
                            if (nums[left] <= nums[mid]) {
                                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                                else left = mid + 1;
                            } else {
                                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                                else right = mid - 1;
                            }
                        }
                        return -1;
                    }
                };
                ```
            """
            ),
            Question(
                name = "3Sum",
                link = "https://leetcode.com/problems/3sum/",
                solutionJava = """
                ```java
                // Class: ThreeSumSolution
                class ThreeSumSolution {
                    public List<List<Integer>> threeSum(int[] nums) {
                        List<List<Integer>> result = new ArrayList<>();
                        Arrays.sort(nums);
                        for (int i = 0; i < nums.length - 2; i++) {
                            if (i > 0 && nums[i] == nums[i - 1]) continue;
                            int left = i + 1, right = nums.length - 1;
                            while (left < right) {
                                int sum = nums[i] + nums[left] + nums[right];
                                if (sum == 0) {
                                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                                    while (left < right && nums[left] == nums[left + 1]) left++;
                                    while (left < right && nums[right] == nums[right - 1]) right--;
                                    left++;
                                    right--;
                                } else if (sum < 0) left++;
                                else right--;
                            }
                        }
                        return result;
                    }
                }
                ```
            """,
                solutionCpp = """
                ```cpp
                // Class: ThreeSumSolution
                class ThreeSumSolution {
                public:
                    vector<vector<int>> threeSum(vector<int>& nums) {
                        vector<vector<int>> result;
                        sort(nums.begin(), nums.end());
                        for (int i = 0; i < nums.size() - 2; i++) {
                            if (i > 0 && nums[i] == nums[i - 1]) continue;
                            int left = i + 1, right = nums.size() - 1;
                            while (left < right) {
                                int sum = nums[i] + nums[left] + nums[right];
                                if (sum == 0) {
                                    result.push_back({ nums[i], nums[left], nums[right] });
                                    while (left < right && nums[left] == nums[left + 1]) left++;
                                    while (left < right && nums[right] == nums[right - 1]) right--;
                                    left++;
                                    right--;
                                } else if (sum < 0) left++;
                                else right--;
                            }
                        }
                        return result;
                    }
                };
                ```
            """
            ),
            Question(
                "Container With Most Water",
                "https://leetcode.com/problems/container-with-most-water/"
            ),
            Question(
                "Subarray Sum Equals K", "https://leetcode.com/problems/subarray-sum-equals-k/"
            ),
            Question("Next Permutation", "https://leetcode.com/problems/next-permutation/"),
            Question("Spiral Matrix", "https://leetcode.com/problems/spiral-matrix/"),
            Question("Rotate Image", "https://leetcode.com/problems/rotate-image/"),
            Question("Jump Game", "https://leetcode.com/problems/jump-game/")
        ) // done
    ), Topic(
        topicName = "Binary Search",
        topicDetails = "Problems solved using binary search algorithm",
        questions = listOf(
            Question(
                name = "Binary Search",
                link = "https://leetcode.com/problems/binary-search/",
                solutionJava = """
        ```java
        // Class: BinarySearchSolution
        class BinarySearchSolution {
            public int search(int[] nums, int target) {
                int left = 0, right = nums.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] == target) return mid;
                    else if (nums[mid] < target) left = mid + 1;
                    else right = mid - 1;
                }
                return -1;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: BinarySearchSolution
        class BinarySearchSolution {
        public:
            int search(vector<int>& nums, int target) {
                int left = 0, right = nums.size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] == target) return mid;
                    else if (nums[mid] < target) left = mid + 1;
                    else right = mid - 1;
                }
                return -1;
            }
        };
        ```
        """
            ),
            Question(
                name = "Search Insert Position",
                link = "https://leetcode.com/problems/search-insert-position/",
                solutionJava = """
        ```java
        // Class: SearchInsertPositionSolution
        class SearchInsertPositionSolution {
            public int searchInsert(int[] nums, int target) {
                int left = 0, right = nums.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] == target) return mid;
                    else if (nums[mid] < target) left = mid + 1;
                    else right = mid - 1;
                }
                return left;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: SearchInsertPositionSolution
        class SearchInsertPositionSolution {
        public:
            int searchInsert(vector<int>& nums, int target) {
                int left = 0, right = nums.size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] == target) return mid;
                    else if (nums[mid] < target) left = mid + 1;
                    else right = mid - 1;
                }
                return left;
            }
        };
        ```
        """
            ),
            Question(
                name = "Search in Rotated Sorted Array",
                link = "https://leetcode.com/problems/search-in-rotated-sorted-array/",
                solutionJava = """
        ```java
        // Class: SearchInRotatedArraySolution
        class SearchInRotatedArraySolution {
            public int search(int[] nums, int target) {
                int left = 0, right = nums.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] == target) return mid;
                    if (nums[left] <= nums[mid]) {
                        if (nums[left] <= target && target < nums[mid]) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    } else {
                        if (nums[mid] < target && target <= nums[right]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                }
                return -1;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: SearchInRotatedArraySolution
        class SearchInRotatedArraySolution {
        public:
            int search(vector<int>& nums, int target) {
                int left = 0, right = nums.size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] == target) return mid;
                    if (nums[left] <= nums[mid]) {
                        if (nums[left] <= target && target < nums[mid]) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    } else {
                        if (nums[mid] < target && target <= nums[right]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                }
                return -1;
            }
        };
        ```
        """
            ),
            Question(
                name = "Find First and Last Position of Element in Sorted Array",
                link = "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/",
                solutionJava = """
        ```java
        // Class: FindFirstAndLastPositionSolution
        class FindFirstAndLastPositionSolution {
            public int[] searchRange(int[] nums, int target) {
                int[] result = {-1, -1};
                result[0] = findFirst(nums, target);
                result[1] = findLast(nums, target);
                return result;
            }

            private int findFirst(int[] nums, int target) {
                int left = 0, right = nums.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < target) left = mid + 1;
                    else right = mid - 1;
                }
                return left < nums.length && nums[left] == target ? left : -1;
            }

            private int findLast(int[] nums, int target) {
                int left = 0, right = nums.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] <= target) left = mid + 1;
                    else right = mid - 1;
                }
                return right >= 0 && nums[right] == target ? right : -1;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: FindFirstAndLastPositionSolution
        class FindFirstAndLastPositionSolution {
        public:
            vector<int> searchRange(vector<int>& nums, int target) {
                vector<int> result{-1, -1};
                result[0] = findFirst(nums, target);
                result[1] = findLast(nums, target);
                return result;
            }

            int findFirst(vector<int>& nums, int target) {
                int left = 0, right = nums.size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < target) left = mid + 1;
                    else right = mid - 1;
                }
                return (left < nums.size() && nums[left] == target) ? left : -1;
            }

            int findLast(vector<int>& nums, int target) {
                int left = 0, right = nums.size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] <= target) left = mid + 1;
                    else right = mid - 1;
                }
                return (right >= 0 && nums[right] == target) ? right : -1;
            }
        };
        ```
        """
            ),
            Question(
                name = "Search a 2D Matrix",
                link = "https://leetcode.com/problems/search-a-2d-matrix/",
                solutionJava = """
        ```java
        // Class: Search2DMatrixSolution
        class Search2DMatrixSolution {
            public boolean searchMatrix(int[][] matrix, int target) {
                if (matrix.length == 0) return false;
                int rows = matrix.length, cols = matrix[0].length;
                int left = 0, right = rows * cols - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    int midValue = matrix[mid / cols][mid % cols];
                    if (midValue == target) return true;
                    else if (midValue < target) left = mid + 1;
                    else right = mid - 1;
                }
                return false;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: Search2DMatrixSolution
        class Search2DMatrixSolution {
        public:
            bool searchMatrix(vector<vector<int>>& matrix, int target) {
                if (matrix.empty()) return false;
                int rows = matrix.size(), cols = matrix[0].size();
                int left = 0, right = rows * cols - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    int midValue = matrix[mid / cols][mid % cols];
                    if (midValue == target) return true;
                    else if (midValue < target) left = mid + 1;
                    else right = mid - 1;
                }
                return false;
            }
        };
        ```
        """
            ),
            Question(
                name = "Find Minimum in Rotated Sorted Array",
                link = "https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/",
                solutionJava = """
        ```java
        // Class: FindMinimumInRotatedSortedArraySolution
        class FindMinimumInRotatedSortedArraySolution {
            public int findMin(int[] nums) {
                int left = 0, right = nums.length - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] > nums[right]) left = mid + 1;
                    else right = mid;
                }
                return nums[left];
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: FindMinimumInRotatedSortedArraySolution
        class FindMinimumInRotatedSortedArraySolution {
        public:
            int findMin(vector<int>& nums) {
                int left = 0, right = nums.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] > nums[right]) left = mid + 1;
                    else right = mid;
                }
                return nums[left];
            }
        };
        ```
        """
            ),
            Question(
                name = "Peak Index in a Mountain Array",
                link = "https://leetcode.com/problems/peak-index-in-a-mountain-array/",
                solutionJava = """
        ```java
        // Class: PeakIndexInMountainArraySolution
        class PeakIndexInMountainArraySolution {
            public int peakIndexInMountainArray(int[] arr) {
                int left = 0, right = arr.length - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (arr[mid] < arr[mid + 1]) left = mid + 1;
                    else right = mid;
                }
                return left;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: PeakIndexInMountainArraySolution
        class PeakIndexInMountainArraySolution {
        public:
            int peakIndexInMountainArray(vector<int>& arr) {
                int left = 0, right = arr.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (arr[mid] < arr[mid + 1]) left = mid + 1;
                    else right = mid;
                }
                return left;
            }
        };
        ```
        """
            ),
            Question(
                name = "Find Peak Element",
                link = "https://leetcode.com/problems/find-peak-element/",
                solutionJava = """
        ```java
        // Class: FindPeakElementSolution
        class FindPeakElementSolution {
            public int findPeakElement(int[] nums) {
                int left = 0, right = nums.length - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < nums[mid + 1]) left = mid + 1;
                    else right = mid;
                }
                return left;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: FindPeakElementSolution
        class FindPeakElementSolution {
        public:
            int findPeakElement(vector<int>& nums) {
                int left = 0, right = nums.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < nums[mid + 1]) left = mid + 1;
                    else right = mid;
                }
                return left;
            }
        };
        ```
        """
            ),
            Question(
                name = "Sqrt(x)",
                link = "https://leetcode.com/problems/sqrtx/",
                solutionJava = """
        ```java
        // Class: SqrtSolution
        class SqrtSolution {
            public int mySqrt(int x) {
                int left = 0, right = x;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (mid * mid == x) return mid;
                    else if (mid * mid < x) left = mid + 1;
                    else right = mid - 1;
                }
                return right;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: SqrtSolution
        class SqrtSolution {
        public:
            int mySqrt(int x) {
                int left = 0, right = x;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (mid * mid == x) return mid;
                    else if (mid * mid < x) left = mid + 1;
                    else right = mid - 1;
                }
                return right;
            }
        };
        ```
        """
            ),
            Question(
                name = "Guess Number Higher or Lower",
                link = "https://leetcode.com/problems/guess-number-higher-or-lower/",
                solutionJava = """
        ```java
        // Class: GuessNumberSolution
        class GuessNumberSolution extends GuessGame {
            public int guessNumber(int n) {
                int left = 1, right = n;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    int result = guess(mid);
                    if (result == 0) return mid;
                    else if (result < 0) right = mid - 1;
                    else left = mid + 1;
                }
                return -1; // Should not reach here
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: GuessNumberSolution
        class GuessNumberSolution : GuessGame {
        public:
            int guessNumber(int n) {
                int left = 1, right = n;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    int result = guess(mid);
                    if (result == 0) return mid;
                    else if (result < 0) right = mid - 1;
                    else left = mid + 1;
                }
                return -1; // Should not reach here
            }
        };
        ```
        """
            ),
            Question(
                name = "Capacity To Ship Packages Within D Days",
                link = "https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/",
                solutionJava = """
        ```java
        // Class: ShipWithinDaysSolution
        class ShipWithinDaysSolution {
            public int shipWithinDays(int[] weights, int D) {
                int left = 0, right = 0;
                for (int weight : weights) {
                    left = Math.max(left, weight);
                    right += weight;
                }
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    int daysNeeded = 1, currentWeight = 0;
                    for (int weight : weights) {
                        if (currentWeight + weight > mid) {
                            daysNeeded++;
                            currentWeight = 0;
                        }
                        currentWeight += weight;
                    }
                    if (daysNeeded <= D) right = mid;
                    else left = mid + 1;
                }
                return left;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: ShipWithinDaysSolution
        class ShipWithinDaysSolution {
        public:
            int shipWithinDays(vector<int>& weights, int D) {
                int left = 0, right = 0;
                for (int weight : weights) {
                    left = max(left, weight);
                    right += weight;
                }
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    int daysNeeded = 1, currentWeight = 0;
                    for (int weight : weights) {
                        if (currentWeight + weight > mid) {
                            daysNeeded++;
                            currentWeight = 0;
                        }
                        currentWeight += weight;
                    }
                    if (daysNeeded <= D) right = mid;
                    else left = mid + 1;
                }
                return left;
            }
        };
        ```
        """
            ),
            Question(
                name = "Koko Eating Bananas",
                link = "https://leetcode.com/problems/koko-eating-bananas/",
                solutionJava = """
        ```java
        // Class: KokoEatingBananasSolution
        class KokoEatingBananasSolution {
            public int minEatingSpeed(int[] piles, int H) {
                int left = 1, right = 0;
                for (int pile : piles) right = Math.max(right, pile);
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    int hoursNeeded = 0;
                    for (int pile : piles) hoursNeeded += (pile + mid - 1) / mid; // Ceil division
                    if (hoursNeeded > H) left = mid + 1;
                    else right = mid;
                }
                return left;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: KokoEatingBananasSolution
        class KokoEatingBananasSolution {
        public:
            int minEatingSpeed(vector<int>& piles, int H) {
                int left = 1, right = 0;
                for (int pile : piles) right = max(right, pile);
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    int hoursNeeded = 0;
                    for (int pile : piles) hoursNeeded += (pile + mid - 1) / mid; // Ceil division
                    if (hoursNeeded > H) left = mid + 1;
                    else right = mid;
                }
                return left;
            }
        };
        ```
        """
            ),
            Question(
                name = "Median of Two Sorted Arrays",
                link = "https://leetcode.com/problems/median-of-two-sorted-arrays/",
                solutionJava = """
        ```java
        // Class: MedianOfTwoSortedArraysSolution
        class MedianOfTwoSortedArraysSolution {
            public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                if (nums1.length > nums2.length) {
                    int[] temp = nums1; nums1 = nums2; nums2 = temp;
                }
                int n1 = nums1.length, n2 = nums2.length;
                int left = 0, right = n1, halfLength = (n1 + n2 + 1) / 2;
                while (left <= right) {
                    int i = left + (right - left) / 2;
                    int j = halfLength - i;
                    int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
                    int minRight1 = (i == n1) ? Integer.MAX_VALUE : nums1[i];
                    int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
                    int minRight2 = (j == n2) ? Integer.MAX_VALUE : nums2[j];
                    
                    if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                        if ((n1 + n2) % 2 == 0) return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                        else return Math.max(maxLeft1, maxLeft2);
                    } else if (maxLeft1 > minRight2) right = i - 1;
                    else left = i + 1;
                }
                throw new IllegalArgumentException("Input arrays are not sorted");
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: MedianOfTwoSortedArraysSolution
        class MedianOfTwoSortedArraysSolution {
        public:
            double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
                if (nums1.size() > nums2.size()) {
                    swap(nums1, nums2);
                }
                int n1 = nums1.size(), n2 = nums2.size();
                int left = 0, right = n1, halfLength = (n1 + n2 + 1) / 2;
                while (left <= right) {
                    int i = left + (right - left) / 2;
                    int j = halfLength - i;
                    int maxLeft1 = (i == 0) ? INT_MIN : nums1[i - 1];
                    int minRight1 = (i == n1) ? INT_MAX : nums1[i];
                    int maxLeft2 = (j == 0) ? INT_MIN : nums2[j - 1];
                    int minRight2 = (j == n2) ? INT_MAX : nums2[j];

                    if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                        if ((n1 + n2) % 2 == 0) return (max(maxLeft1, maxLeft2) + min(minRight1, minRight2)) / 2.0;
                        else return max(maxLeft1, maxLeft2);
                    } else if (maxLeft1 > minRight2) right = i - 1;
                    else left = i + 1;
                }
                throw invalid_argument("Input arrays are not sorted");
            }
        };
        ```
        """
            ),
            Question(
                name = "Find the Duplicate Number",
                link = "https://leetcode.com/problems/find-the-duplicate-number/",
                solutionJava = """
        ```java
        // Class: FindDuplicateNumberSolution
        class FindDuplicateNumberSolution {
            public int findDuplicate(int[] nums) {
                int slow = nums[0], fast = nums[0];
                do {
                    slow = nums[slow];
                    fast = nums[nums[fast]];
                } while (slow != fast);
                
                slow = nums[0];
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: FindDuplicateNumberSolution
        class FindDuplicateNumberSolution {
        public:
            int findDuplicate(vector<int>& nums) {
                int slow = nums[0], fast = nums[0];
                do {
                    slow = nums[slow];
                    fast = nums[nums[fast]];
                } while (slow != fast);
                
                slow = nums[0];
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        };
        ```
        """
            ),
            Question(
                name = "Split Array Largest Sum",
                link = "https://leetcode.com/problems/split-array-largest-sum/",
                solutionJava = """
        ```java
        // Class: SplitArrayLargestSumSolution
        class SplitArrayLargestSumSolution {
            public int splitArray(int[] nums, int m) {
                int left = 0, right = 0;
                for (int num : nums) {
                    left = Math.max(left, num);
                    right += num;
                }
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    int pieces = 1, currentSum = 0;
                    for (int num : nums) {
                        if (currentSum + num > mid) {
                            pieces++;
                            currentSum = 0;
                        }
                        currentSum += num;
                    }
                    if (pieces <= m) right = mid;
                    else left = mid + 1;
                }
                return left;
            }
        }
        ```
        """,
                solutionCpp = """
        ```cpp
        // Class: SplitArrayLargestSumSolution
        class SplitArrayLargestSumSolution {
        public:
            int splitArray(vector<int>& nums, int m) {
                int left = 0, right = 0;
                for (int num : nums) {
                    left = max(left, num);
                    right += num;
                }
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    int pieces = 1, currentSum = 0;
                    for (int num : nums) {
                        if (currentSum + num > mid) {
                            pieces++;
                            currentSum = 0;
                        }
                        currentSum += num;
                    }
                    if (pieces <= m) right = mid;
                    else left = mid + 1;
                }
                return left;
            }
        };
        ```
        """
            )

        ) // done
    ), Topic(
        topicName = "Strings",
        topicDetails = "Problems focused on string manipulation and algorithms",
        questions = listOf(
            Question(
                name = "Reverse String",
                link = "https://leetcode.com/problems/reverse-string/",
                solutionJava = """
            class ReverseString {
                public void reverseString(char[] s) {
                    int left = 0, right = s.length - 1;
                    while (left < right) {
                        char temp = s[left];
                        s[left] = s[right];
                        s[right] = temp;
                        left++;
                        right--;
                    }
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                void reverseString(vector<char>& s) {
                    int left = 0, right = s.size() - 1;
                    while (left < right) {
                        swap(s[left], s[right]);
                        left++;
                        right--;
                    }
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Valid Anagram",
                link = "https://leetcode.com/problems/valid-anagram/",
                solutionJava = """
            class ValidAnagram {
                public boolean isAnagram(String s, String t) {
                    if (s.length() != t.length()) return false;
                    int[] count = new int[26];
                    for (int i = 0; i < s.length(); i++) {
                        count[s.charAt(i) - 'a']++;
                        count[t.charAt(i) - 'a']--;
                    }
                    for (int c : count) {
                        if (c != 0) return false;
                    }
                    return true;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                bool isAnagram(string s, string t) {
                    if (s.length() != t.length()) return false;
                    vector<int> count(26, 0);
                    for (char c : s) count[c - 'a']++;
                    for (char c : t) {
                        if (--count[c - 'a'] < 0) return false;
                    }
                    return true;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Longest Common Prefix",
                link = "https://leetcode.com/problems/longest-common-prefix/",
                solutionJava = """
            class LongestCommonPrefix {
                public String longestCommonPrefix(String[] strs) {
                    if (strs.length == 0) return "";
                    String prefix = strs[0];
                    for (int i = 1; i < strs.length; i++) {
                        while (strs[i].indexOf(prefix) != 0) {
                            prefix = prefix.substring(0, prefix.length() - 1);
                            if (prefix.isEmpty()) return "";
                        }
                    }
                    return prefix;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                string longestCommonPrefix(vector<string>& strs) {
                    if (strs.empty()) return "";
                    string prefix = strs[0];
                    for (int i = 1; i < strs.size(); i++) {
                        while (strs[i].find(prefix) != 0) {
                            prefix = prefix.substr(0, prefix.size() - 1);
                            if (prefix.empty()) return "";
                        }
                    }
                    return prefix;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Valid Palindrome",
                link = "https://leetcode.com/problems/valid-palindrome/",
                solutionJava = """
            class ValidPalindrome {
                public boolean isPalindrome(String s) {
                    String filtered = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    int left = 0, right = filtered.length() - 1;
                    while (left < right) {
                        if (filtered.charAt(left) != filtered.charAt(right)) return false;
                        left++;
                        right--;
                    }
                    return true;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                bool isPalindrome(string s) {
                    string filtered;
                    for (char c : s) {
                        if (isalnum(c)) {
                            filtered += tolower(c);
                        }
                    }
                    int left = 0, right = filtered.size() - 1;
                    while (left < right) {
                        if (filtered[left] != filtered[right]) return false;
                        left++;
                        right--;
                    }
                    return true;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "String to Integer (atoi)",
                link = "https://leetcode.com/problems/string-to-integer-atoi/",
                solutionJava = """
            class StringToInteger {
                public int myAtoi(String s) {
                    s = s.trim();
                    if (s.isEmpty()) return 0;
                    int sign = 1, index = 0, total = 0;
                    if (s.charAt(0) == '-' || s.charAt(0) == '+') {
                        sign = (s.charAt(0) == '-') ? -1 : 1;
                        index++;
                    }
                    while (index < s.length()) {
                        int digit = s.charAt(index) - '0';
                        if (digit < 0 || digit > 9) break;
                        if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > 7)) {
                            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        }
                        total = total * 10 + digit;
                        index++;
                    }
                    return total * sign;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int myAtoi(string s) {
                    int index = 0, sign = 1, total = 0;
                    while (index < s.length() && isspace(s[index])) index++;
                    if (index < s.length() && (s[index] == '-' || s[index] == '+')) {
                        sign = (s[index++] == '-') ? -1 : 1;
                    }
                    while (index < s.length() && isdigit(s[index])) {
                        int digit = s[index] - '0';
                        if (total > INT_MAX / 10 || (total == INT_MAX / 10 && digit > 7)) {
                            return (sign == 1) ? INT_MAX : INT_MIN;
                        }
                        total = total * 10 + digit;
                        index++;
                    }
                    return total * sign;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Longest Substring Without Repeating Characters",
                link = "https://leetcode.com/problems/longest-substring-without-repeating-characters/",
                solutionJava = """
            class LongestSubstring {
                public int lengthOfLongestSubstring(String s) {
                    HashSet<Character> set = new HashSet<>();
                    int left = 0, maxLength = 0;
                    for (int right = 0; right < s.length(); right++) {
                        while (set.contains(s.charAt(right))) {
                            set.remove(s.charAt(left));
                            left++;
                        }
                        set.add(s.charAt(right));
                        maxLength = Math.max(maxLength, right - left + 1);
                    }
                    return maxLength;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int lengthOfLongestSubstring(string s) {
                    unordered_set<char> set;
                    int left = 0, maxLength = 0;
                    for (int right = 0; right < s.size(); right++) {
                        while (set.count(s[right])) {
                            set.erase(s[left]);
                            left++;
                        }
                        set.insert(s[right]);
                        maxLength = max(maxLength, right - left + 1);
                    }
                    return maxLength;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Longest Palindromic Substring",
                link = "https://leetcode.com/problems/longest-palindromic-substring/",
                solutionJava = """
            class LongestPalindromicSubstring {
                public String longestPalindrome(String s) {
                    if (s.length() < 1) return "";
                    int start = 0, end = 0;
                    for (int i = 0; i < s.length(); i++) {
                        int len1 = expandAroundCenter(s, i, i);
                        int len2 = expandAroundCenter(s, i, i + 1);
                        int len = Math.max(len1, len2);
                        if (len > end - start) {
                            start = i - (len - 1) / 2;
                            end = i + len / 2;
                        }
                    }
                    return s.substring(start, end + 1);
                }

                private int expandAroundCenter(String s, int left, int right) {
                    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                    }
                    return right - left - 1;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                string longestPalindrome(string s) {
                    if (s.size() < 1) return "";
                    int start = 0, end = 0;
                    for (int i = 0; i < s.size(); i++) {
                        int len1 = expandAroundCenter(s, i, i);
                        int len2 = expandAroundCenter(s, i, i + 1);
                        int len = max(len1, len2);
                        if (len > end - start) {
                            start = i - (len - 1) / 2;
                            end = i + len / 2;
                        }
                    }
                    return s.substr(start, end - start + 1);
                }

                int expandAroundCenter(string s, int left, int right) {
                    while (left >= 0 && right < s.size() && s[left] == s[right]) {
                        left--;
                        right++;
                    }
                    return right - left - 1;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Group Anagrams",
                link = "https://leetcode.com/problems/group-anagrams/",
                solutionJava = """
            class GroupAnagrams {
                public List<List<String>> groupAnagrams(String[] strs) {
                    Map<String, List<String>> map = new HashMap<>();
                    for (String str : strs) {
                        char[] charArray = str.toCharArray();
                        Arrays.sort(charArray);
                        String sorted = new String(charArray);
                        map.putIfAbsent(sorted, new ArrayList<>());
                        map.get(sorted).add(str);
                    }
                    return new ArrayList<>(map.values());
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                vector<vector<string>> groupAnagrams(vector<string>& strs) {
                    unordered_map<string, vector<string>> map;
                    for (string str : strs) {
                        string sorted = str;
                        sort(sorted.begin(), sorted.end());
                        map[sorted].push_back(str);
                    }
                    vector<vector<string>> result;
                    for (auto& entry : map) {
                        result.push_back(entry.second);
                    }
                    return result;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Valid Parentheses",
                link = "https://leetcode.com/problems/valid-parentheses/",
                solutionJava = """
            class ValidParentheses {
                public boolean isValid(String s) {
                    Stack<Character> stack = new Stack<>();
                    for (char c : s.toCharArray()) {
                        if (c == '(') stack.push(')');
                        else if (c == '{') stack.push('}');
                        else if (c == '[') stack.push(']');
                        else if (stack.isEmpty() || stack.pop() != c) return false;
                    }
                    return stack.isEmpty();
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                bool isValid(string s) {
                    stack<char> stack;
                    for (char c : s) {
                        if (c == '(') stack.push(')');
                        else if (c == '{') stack.push('}');
                        else if (c == '[') stack.push(']');
                        else if (stack.empty() || stack.top() != c) return false;
                        else stack.pop();
                    }
                    return stack.empty();
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Generate Parentheses",
                link = "https://leetcode.com/problems/generate-parentheses/",
                solutionJava = """
            class GenerateParentheses {
                public List<String> generateParenthesis(int n) {
                    List<String> result = new ArrayList<>();
                    generate(result, "", 0, 0, n);
                    return result;
                }

                private void generate(List<String> result, String current, int open, int close, int max) {
                    if (current.length() == max * 2) {
                        result.add(current);
                        return;
                    }
                    if (open < max) generate(result, current + "(", open + 1, close, max);
                    if (close < open) generate(result, current + ")", open, close + 1, max);
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                vector<string> generateParenthesis(int n) {
                    vector<string> result;
                    generate(result, "", 0, 0, n);
                    return result;
                }

                void generate(vector<string>& result, string current, int open, int close, int max) {
                    if (current.size() == max * 2) {
                        result.push_back(current);
                        return;
                    }
                    if (open < max) generate(result, current + "(", open + 1, close, max);
                    if (close < open) generate(result, current + ")", open, close + 1, max);
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Implement strStr()",
                link = "https://leetcode.com/problems/implement-strstr/",
                solutionJava = """
            class ImplementStrStr {
                public int strStr(String haystack, String needle) {
                    if (needle.isEmpty()) return 0;
                    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                        if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
                    }
                    return -1;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int strStr(string haystack, string needle) {
                    if (needle.empty()) return 0;
                    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                        if (haystack.substr(i, needle.length()) == needle) return i;
                    }
                    return -1;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Zigzag Conversion",
                link = "https://leetcode.com/problems/zigzag-conversion/",
                solutionJava = """
            class ZigzagConversion {
                public String convert(String s, int numRows) {
                    if (numRows <= 1) return s;
                    StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
                    for (int i = 0; i < rows.length; i++) rows[i] = new StringBuilder();
                    int curRow = 0, goingDown = 0;
                    for (char c : s.toCharArray()) {
                        rows[curRow].append(c);
                        if (curRow == 0) goingDown = 1;
                        else if (curRow == numRows - 1) goingDown = -1;
                        curRow += goingDown;
                    }
                    StringBuilder result = new StringBuilder();
                    for (StringBuilder row : rows) result.append(row);
                    return result.toString();
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                string convert(string s, int numRows) {
                    if (numRows <= 1) return s;
                    vector<string> rows(min(numRows, (int)s.size()), "");
                    int curRow = 0, goingDown = 0;
                    for (char c : s) {
                        rows[curRow] += c;
                        if (curRow == 0) goingDown = 1;
                        else if (curRow == numRows - 1) goingDown = -1;
                        curRow += goingDown;
                    }
                    string result;
                    for (string row : rows) result += row;
                    return result;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Letter Combinations of a Phone Number",
                link = "https://leetcode.com/problems/letter-combinations-of-a-phone-number/",
                solutionJava = """
            class LetterCombinations {
                public List<String> letterCombinations(String digits) {
                    List<String> result = new ArrayList<>();
                    if (digits.isEmpty()) return result;
                    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
                    backtrack(result, new StringBuilder(), digits, 0, mapping);
                    return result;
                }

                private void backtrack(List<String> result, StringBuilder combination, String digits, int index, String[] mapping) {
                    if (index == digits.length()) {
                        result.add(combination.toString());
                        return;
                    }
                    String letters = mapping[digits.charAt(index) - '0'];
                    for (char letter : letters.toCharArray()) {
                        combination.append(letter);
                        backtrack(result, combination, digits, index + 1, mapping);
                        combination.deleteCharAt(combination.length() - 1);
                    }
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                vector<string> letterCombinations(string digits) {
                    vector<string> result;
                    if (digits.empty()) return result;
                    string mapping[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
                    backtrack(result, "", digits, 0, mapping);
                    return result;
                }

                void backtrack(vector<string>& result, string combination, string digits, int index, string mapping[]) {
                    if (index == digits.size()) {
                        result.push_back(combination);
                        return;
                    }
                    string letters = mapping[digits[index] - '0'];
                    for (char letter : letters) {
                        backtrack(result, combination + letter, digits, index + 1, mapping);
                    }
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Longest Valid Parentheses",
                link = "https://leetcode.com/problems/longest-valid-parentheses/",
                solutionJava = """
            class LongestValidParentheses {
                public int longestValidParentheses(String s) {
                    int maxLen = 0;
                    Stack<Integer> stack = new Stack<>();
                    stack.push(-1);
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '(') stack.push(i);
                        else {
                            stack.pop();
                            if (stack.isEmpty()) stack.push(i);
                            else maxLen = Math.max(maxLen, i - stack.peek());
                        }
                    }
                    return maxLen;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int longestValidParentheses(string s) {
                    int maxLen = 0;
                    stack<int> stack;
                    stack.push(-1);
                    for (int i = 0; i < s.size(); i++) {
                        if (s[i] == '(') stack.push(i);
                        else {
                            stack.pop();
                            if (stack.empty()) stack.push(i);
                            else maxLen = max(maxLen, i - stack.top());
                        }
                    }
                    return maxLen;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Minimum Window Substring",
                link = "https://leetcode.com/problems/minimum-window-substring/",
                solutionJava = """
            class MinimumWindowSubstring {
                public String minWindow(String s, String t) {
                    if (t.length() > s.length()) return "";
                    Map<Character, Integer> dictT = new HashMap<>();
                    for (char c : t.toCharArray()) dictT.put(c, dictT.getOrDefault(c, 0) + 1);
                    int required = dictT.size();
                    int l = 0, r = 0, formed = 0;
                    Map<Character, Integer> windowCounts = new HashMap<>();
                    int[] ans = {-1, 0, 0}; // Length of the substring, left, right
                    while (r < s.length()) {
                        char c = s.charAt(r);
                        windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
                        if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue())
                            formed++;
                        while (l <= r && formed == required) {
                            c = s.charAt(l);
                            if (ans[0] == -1 || r - l + 1 < ans[0]) {
                                ans[0] = r - l + 1;
                                ans[1] = l;
                                ans[2] = r;
                            }
                            windowCounts.put(c, windowCounts.get(c) - 1);
                            if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue())
                                formed--;
                            l++;
                        }
                        r++;
                    }
                    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                string minWindow(string s, string t) {
                    if (t.size() > s.size()) return "";
                    unordered_map<char, int> dictT;
                    for (char c : t) dictT[c]++;
                    int required = dictT.size();
                    int l = 0, r = 0, formed = 0;
                    unordered_map<char, int> windowCounts;
                    int ans[3] = {-1, 0, 0}; // Length of the substring, left, right
                    while (r < s.size()) {
                        char c = s[r];
                        windowCounts[c]++;
                        if (dictT.count(c) && windowCounts[c] == dictT[c]) formed++;
                        while (l <= r && formed == required) {
                            c = s[l];
                            if (ans[0] == -1 || r - l + 1 < ans[0]) {
                                ans[0] = r - l + 1;
                                ans[1] = l;
                                ans[2] = r;
                            }
                            windowCounts[c]--;
                            if (dictT.count(c) && windowCounts[c] < dictT[c]) formed--;
                            l++;
                        }
                        r++;
                    }
                    return ans[0] == -1 ? "" : s.substr(ans[1], ans[2] - ans[1] + 1);
                }
            };
        """.trimIndent()
            )
        ) // done
    ), Topic(
        topicName = "Linked List",
        topicDetails = "Problems related to linked list data structure",
        questions = listOf(
            Question(
                name = "Reverse Linked List",
                link = "https://leetcode.com/problems/reverse-linked-list/",
                solutionJava = """
                class Solution {
                    public ListNode reverseList(ListNode head) {
                        ListNode prev = null;
                        while (head != null) {
                            ListNode next = head.next;
                            head.next = prev;
                            prev = head;
                            head = next;
                        }
                        return prev;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    ListNode* reverseList(ListNode* head) {
                        ListNode* prev = nullptr;
                        while (head != nullptr) {
                            ListNode* next = head->next;
                            head->next = prev;
                            prev = head;
                            head = next;
                        }
                        return prev;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Merge Two Sorted Lists",
                link = "https://leetcode.com/problems/merge-two-sorted-lists/",
                solutionJava = """
                class Solution {
                    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
                        if (l1 == null) return l2;
                        if (l2 == null) return l1;
                        if (l1.val < l2.val) {
                            l1.next = mergeTwoLists(l1.next, l2);
                            return l1;
                        } else {
                            l2.next = mergeTwoLists(l1, l2.next);
                            return l2;
                        }
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
                        if (!l1) return l2;
                        if (!l2) return l1;
                        if (l1->val < l2->val) {
                            l1->next = mergeTwoLists(l1->next, l2);
                            return l1;
                        } else {
                            l2->next = mergeTwoLists(l1, l2->next);
                            return l2;
                        }
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Linked List Cycle",
                link = "https://leetcode.com/problems/linked-list-cycle/",
                solutionJava = """
                class Solution {
                    public boolean hasCycle(ListNode head) {
                        ListNode slow = head;
                        ListNode fast = head;
                        while (fast != null && fast.next != null) {
                            slow = slow.next;
                            fast = fast.next.next;
                            if (slow == fast) return true;
                        }
                        return false;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    bool hasCycle(ListNode *head) {
                        ListNode *slow = head, *fast = head;
                        while (fast != nullptr && fast->next != nullptr) {
                            slow = slow->next;
                            fast = fast->next->next;
                            if (slow == fast) return true;
                        }
                        return false;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Remove Nth Node From End of List",
                link = "https://leetcode.com/problems/remove-nth-node-from-end-of-list/",
                solutionJava = """
                class Solution {
                    public ListNode removeNthFromEnd(ListNode head, int n) {
                        ListNode dummy = new ListNode(0);
                        dummy.next = head;
                        ListNode first = dummy;
                        ListNode second = dummy;
                        for (int i = 1; i <= n + 1; i++) {
                            first = first.next;
                        }
                        while (first != null) {
                            first = first.next;
                            second = second.next;
                        }
                        second.next = second.next.next;
                        return dummy.next;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    ListNode* removeNthFromEnd(ListNode* head, int n) {
                        ListNode dummy(0);
                        dummy.next = head;
                        ListNode* first = &dummy;
                        ListNode* second = &dummy;
                        for (int i = 1; i <= n + 1; i++) {
                            first = first->next;
                        }
                        while (first != nullptr) {
                            first = first->next;
                            second = second->next;
                        }
                        second->next = second->next->next;
                        return dummy.next;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Add Two Numbers",
                link = "https://leetcode.com/problems/add-two-numbers/",
                solutionJava = """
                class Solution {
                    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                        ListNode dummy = new ListNode(0);
                        ListNode p = l1, q = l2, current = dummy;
                        int carry = 0;
                        while (p != null || q != null) {
                            int x = (p != null) ? p.val : 0;
                            int y = (q != null) ? q.val : 0;
                            int sum = carry + x + y;
                            carry = sum / 10;
                            current.next = new ListNode(sum % 10);
                            current = current.next;
                            if (p != null) p = p.next;
                            if (q != null) q = q.next;
                        }
                        if (carry > 0) {
                            current.next = new ListNode(carry);
                        }
                        return dummy.next;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
                        ListNode dummy(0);
                        ListNode* current = &dummy;
                        int carry = 0;
                        while (l1 != nullptr || l2 != nullptr) {
                            int x = (l1 != nullptr) ? l1->val : 0;
                            int y = (l2 != nullptr) ? l2->val : 0;
                            int sum = carry + x + y;
                            carry = sum / 10;
                            current->next = new ListNode(sum % 10);
                            current = current->next;
                            if (l1 != nullptr) l1 = l1->next;
                            if (l2 != nullptr) l2 = l2->next;
                        }
                        if (carry > 0) {
                            current->next = new ListNode(carry);
                        }
                        return dummy.next;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Intersection of Two Linked Lists",
                link = "https://leetcode.com/problems/intersection-of-two-linked-lists/",
                solutionJava = """
                class Solution {
                    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                        if (headA == null || headB == null) return null;
                        ListNode a = headA;
                        ListNode b = headB;
                        while (a != b) {
                            a = (a == null) ? headB : a.next;
                            b = (b == null) ? headA : b.next;
                        }
                        return a;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
                        if (!headA || !headB) return nullptr;
                        ListNode *a = headA, *b = headB;
                        while (a != b) {
                            a = (a == nullptr) ? headB : a->next;
                            b = (b == nullptr) ? headA : b->next;
                        }
                        return a;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Palindrome Linked List",
                link = "https://leetcode.com/problems/palindrome-linked-list/",
                solutionJava = """
                class Solution {
                    public boolean isPalindrome(ListNode head) {
                        if (head == null || head.next == null) return true;
                        ListNode slow = head, fast = head;
                        while (fast != null && fast.next != null) {
                            slow = slow.next;
                            fast = fast.next.next;
                        }
                        ListNode prev = null;
                        while (slow != null) {
                            ListNode next = slow.next;
                            slow.next = prev;
                            prev = slow;
                            slow = next;
                        }
                        ListNode left = head, right = prev;
                        while (right != null) {
                            if (left.val != right.val) return false;
                            left = left.next;
                            right = right.next;
                        }
                        return true;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    bool isPalindrome(ListNode* head) {
                        if (!head || !head->next) return true;
                        ListNode* slow = head, *fast = head;
                        while (fast && fast->next) {
                            slow = slow->next;
                            fast = fast->next->next;
                        }
                        ListNode* prev = nullptr;
                        while (slow) {
                            ListNode* next = slow->next;
                            slow->next = prev;
                            prev = slow;
                            slow = next;
                        }
                        ListNode* left = head, *right = prev;
                        while (right) {
                            if (left->val != right->val) return false;
                            left = left->next;
                            right = right->next;
                        }
                        return true;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Remove Linked List Elements",
                link = "https://leetcode.com/problems/remove-linked-list-elements/",
                solutionJava = """
                class Solution {
                    public ListNode removeElements(ListNode head, int val) {
                        ListNode dummy = new ListNode(0);
                        dummy.next = head;
                        ListNode current = dummy;
                        while (current.next != null) {
                            if (current.next.val == val) {
                                current.next = current.next.next;
                            } else {
                                current = current.next;
                            }
                        }
                        return dummy.next;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    ListNode* removeElements(ListNode* head, int val) {
                        ListNode dummy(0);
                        dummy.next = head;
                        ListNode* current = &dummy;
                        while (current->next != nullptr) {
                            if (current->next->val == val) {
                                current->next = current->next->next;
                            } else {
                                current = current->next;
                            }
                        }
                        return dummy.next;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Odd Even Linked List",
                link = "https://leetcode.com/problems/odd-even-linked-list/",
                solutionJava = """
                class Solution {
                    public ListNode oddEvenList(ListNode head) {
                        if (head == null) return head;
                        ListNode odd = head, even = head.next, evenHead = even;
                        while (even != null && even.next != null) {
                            odd.next = even.next;
                            odd = odd.next;
                            even.next = odd.next;
                            even = even.next;
                        }
                        odd.next = evenHead;
                        return head;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    ListNode* oddEvenList(ListNode* head) {
                        if (!head) return head;
                        ListNode* odd = head, *even = head->next, *evenHead = even;
                        while (even && even->next) {
                            odd->next = even->next;
                            odd = odd->next;
                            even->next = odd->next;
                            even = even->next;
                        }
                        odd->next = evenHead;
                        return head;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Swap Nodes in Pairs",
                link = "https://leetcode.com/problems/swap-nodes-in-pairs/",
                solutionJava = """
                class Solution {
                    public ListNode swapPairs(ListNode head) {
                        if (head == null || head.next == null) return head;
                        ListNode newHead = head.next;
                        ListNode prev = null;
                        while (head != null && head.next != null) {
                            ListNode first = head;
                            ListNode second = head.next;
                            first.next = second.next;
                            second.next = first;
                            if (prev != null) {
                                prev.next = second;
                            }
                            prev = first;
                            head = first.next;
                        }
                        return newHead;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    ListNode* swapPairs(ListNode* head) {
                        if (!head || !head->next) return head;
                        ListNode* newHead = head->next;
                        ListNode* prev = nullptr;
                        while (head && head->next) {
                            ListNode* first = head;
                            ListNode* second = head->next;
                            first->next = second->next;
                            second->next = first;
                            if (prev) {
                                prev->next = second;
                            }
                            prev = first;
                            head = first->next;
                        }
                        return newHead;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Sort List",
                link = "https://leetcode.com/problems/sort-list/",
                solutionJava = """
                class Solution {
                    public ListNode sortList(ListNode head) {
                        if (head == null || head.next == null) return head;
                        ListNode mid = getMid(head);
                        ListNode left = sortList(head);
                        ListNode right = sortList(mid);
                        return merge(left, right);
                    }
                    
                    private ListNode getMid(ListNode head) {
                        ListNode slow = head, fast = head.next;
                        while (fast != null && fast.next != null) {
                            slow = slow.next;
                            fast = fast.next.next;
                        }
                        ListNode mid = slow.next;
                        slow.next = null;
                        return mid;
                    }

                    private ListNode merge(ListNode l1, ListNode l2) {
                        ListNode dummy = new ListNode(0);
                        ListNode current = dummy;
                        while (l1 != null && l2 != null) {
                            if (l1.val < l2.val) {
                                current.next = l1;
                                l1 = l1.next;
                            } else {
                                current.next = l2;
                                l2 = l2.next;
                            }
                            current = current.next;
                        }
                        current.next = (l1 != null) ? l1 : l2;
                        return dummy.next;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    ListNode* sortList(ListNode* head) {
                        if (!head || !head->next) return head;
                        ListNode* mid = getMid(head);
                        ListNode* left = sortList(head);
                        ListNode* right = sortList(mid);
                        return merge(left, right);
                    }

                    ListNode* getMid(ListNode* head) {
                        ListNode* slow = head;
                        ListNode* fast = head->next;
                        while (fast && fast->next) {
                            slow = slow->next;
                            fast = fast->next->next;
                        }
                        ListNode* mid = slow->next;
                        slow->next = nullptr;
                        return mid;
                    }

                    ListNode* merge(ListNode* l1, ListNode* l2) {
                        ListNode dummy(0);
                        ListNode* current = &dummy;
                        while (l1 && l2) {
                            if (l1->val < l2->val) {
                                current->next = l1;
                                l1 = l1->next;
                            } else {
                                current->next = l2;
                                l2 = l2->next;
                            }
                            current = current->next;
                        }
                        current->next = (l1 != nullptr) ? l1 : l2;
                        return dummy.next;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Reorder List",
                link = "https://leetcode.com/problems/reorder-list/",
                solutionJava = """
                class Solution {
                    public void reorderList(ListNode head) {
                        if (head == null || head.next == null) return;
                        ListNode mid = getMid(head);
                        ListNode second = reverse(mid.next);
                        mid.next = null;
                        merge(head, second);
                    }

                    private ListNode getMid(ListNode head) {
                        ListNode slow = head, fast = head.next;
                        while (fast != null && fast.next != null) {
                            slow = slow.next;
                            fast = fast.next.next;
                        }
                        return slow;
                    }

                    private ListNode reverse(ListNode head) {
                        ListNode prev = null;
                        while (head != null) {
                            ListNode next = head.next;
                            head.next = prev;
                            prev = head;
                            head = next;
                        }
                        return prev;
                    }

                    private void merge(ListNode l1, ListNode l2) {
                        while (l1 != null && l2 != null) {
                            ListNode temp1 = l1.next;
                            ListNode temp2 = l2.next;
                            l1.next = l2;
                            l2.next = temp1;
                            l1 = temp1;
                            l2 = temp2;
                        }
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    void reorderList(ListNode* head) {
                        if (!head || !head->next) return;
                        ListNode* mid = getMid(head);
                        ListNode* second = reverse(mid->next);
                        mid->next = nullptr;
                        merge(head, second);
                    }

                    ListNode* getMid(ListNode* head) {
                        ListNode* slow = head;
                        ListNode* fast = head->next;
                        while (fast && fast->next) {
                            slow = slow->next;
                            fast = fast->next->next;
                        }
                        return slow;
                    }

                    ListNode* reverse(ListNode* head) {
                        ListNode* prev = nullptr;
                        while (head) {
                            ListNode* next = head->next;
                            head->next = prev;
                            prev = head;
                            head = next;
                        }
                        return prev;
                    }

                    void merge(ListNode* l1, ListNode* l2) {
                        while (l1 && l2) {
                            ListNode* temp1 = l1->next;
                            ListNode* temp2 = l2->next;
                            l1->next = l2;
                            l2->next = temp1;
                            l1 = temp1;
                            l2 = temp2;
                        }
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Rotate List",
                link = "https://leetcode.com/problems/rotate-list/",
                solutionJava = """
                class Solution {
                    public ListNode rotateRight(ListNode head, int k) {
                        if (head == null || head.next == null || k == 0) return head;
                        ListNode tail = head;
                        int length = 1;
                        while (tail.next != null) {
                            tail = tail.next;
                            length++;
                        }
                        tail.next = head; // Make it a circular list
                        k = k % length;
                        int stepsToNewHead = length - k;
                        ListNode newTail = head;
                        for (int i = 0; i < stepsToNewHead - 1; i++) {
                            newTail = newTail.next;
                        }
                        ListNode newHead = newTail.next;
                        newTail.next = null; // Break the circular link
                        return newHead;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    ListNode* rotateRight(ListNode* head, int k) {
                        if (!head || !head->next || k == 0) return head;
                        ListNode* tail = head;
                        int length = 1;
                        while (tail->next) {
                            tail = tail->next;
                            length++;
                        }
                        tail->next = head; // Make it a circular list
                        k = k % length;
                        int stepsToNewHead = length - k;
                        ListNode* newTail = head;
                        for (int i = 0; i < stepsToNewHead - 1; i++) {
                            newTail = newTail->next;
                        }
                        ListNode* newHead = newTail->next;
                        newTail->next = nullptr; // Break the circular link
                        return newHead;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Copy List with Random Pointer",
                link = "https://leetcode.com/problems/copy-list-with-random-pointer/",
                solutionJava = """
                class Solution {
                    public Node copyRandomList(Node head) {
                        if (head == null) return null;
                        Map<Node, Node> map = new HashMap<>();
                        Node current = head;
                        // First pass: Create a copy of each node and map them
                        while (current != null) {
                            map.put(current, new Node(current.val));
                            current = current.next;
                        }
                        // Second pass: Assign next and random pointers
                        current = head;
                        while (current != null) {
                            Node copy = map.get(current);
                            copy.next = map.get(current.next);
                            copy.random = map.get(current.random);
                            current = current.next;
                        }
                        return map.get(head);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    Node* copyRandomList(Node* head) {
                        if (!head) return nullptr;
                        unordered_map<Node*, Node*> map;
                        Node* current = head;
                        // First pass: Create a copy of each node and map them
                        while (current) {
                            map[current] = new Node(current->val);
                            current = current->next;
                        }
                        // Second pass: Assign next and random pointers
                        current = head;
                        while (current) {
                            Node* copy = map[current];
                            copy->next = map[current->next];
                            copy->random = map[current->random];
                            current = current->next;
                        }
                        return map[head];
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "LRU Cache",
                link = "https://leetcode.com/problems/lru-cache/",
                solutionJava = """
                class LRUCache {
                    private Map<Integer, ListNode> map;
                    private DoublyLinkedList cache;
                    private int capacity;

                    public LRUCache(int capacity) {
                        this.capacity = capacity;
                        map = new HashMap<>();
                        cache = new DoublyLinkedList();
                    }

                    public int get(int key) {
                        if (!map.containsKey(key)) return -1;
                        ListNode node = map.get(key);
                        cache.moveToHead(node);
                        return node.val;
                    }

                    public void put(int key, int value) {
                        if (map.containsKey(key)) {
                            ListNode node = map.get(key);
                            node.val = value;
                            cache.moveToHead(node);
                        } else {
                            ListNode newNode = new ListNode(key, value);
                            if (cache.size == capacity) {
                                ListNode tail = cache.removeTail();
                                map.remove(tail.key);
                            }
                            cache.addToHead(newNode);
                            map.put(key, newNode);
                        }
                    }
                }

                class DoublyLinkedList {
                    private ListNode head, tail;
                    private int size;

                    public DoublyLinkedList() {
                        head = new ListNode(0);
                        tail = new ListNode(0);
                        head.next = tail;
                        tail.prev = head;
                        size = 0;
                    }

                    public void addToHead(ListNode node) {
                        node.prev = head;
                        node.next = head.next;
                        head.next.prev = node;
                        head.next = node;
                        size++;
                    }

                    public void moveToHead(ListNode node) {
                        remove(node);
                        addToHead(node);
                    }

                    public ListNode removeTail() {
                        ListNode res = tail.prev;
                        remove(res);
                        return res;
                    }

                    private void remove(ListNode node) {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                        size--;
                    }
                }

                class ListNode {
                    int key, val;
                    ListNode prev, next;

                    public ListNode(int key, int val) {
                        this.key = key;
                        this.val = val;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class LRUCache {
                private:
                    unordered_map<int, ListNode*> map;
                    DoublyLinkedList cache;
                    int capacity;

                public:
                    LRUCache(int capacity) {
                        this->capacity = capacity;
                    }

                    int get(int key) {
                        if (map.find(key) == map.end()) return -1;
                        ListNode* node = map[key];
                        cache.moveToHead(node);
                        return node->val;
                    }

                    void put(int key, int value) {
                        if (map.find(key) != map.end()) {
                            ListNode* node = map[key];
                            node->val = value;
                            cache.moveToHead(node);
                        } else {
                            ListNode* newNode = new ListNode(key, value);
                            if (cache.size == capacity) {
                                ListNode* tail = cache.removeTail();
                                map.erase(tail->key);
                            }
                            cache.addToHead(newNode);
                            map[key] = newNode;
                        }
                    }
                };

                class DoublyLinkedList {
                private:
                    ListNode* head;
                    ListNode* tail;
                public:
                    int size;

                    DoublyLinkedList() {
                        head = new ListNode(0, 0);
                        tail = new ListNode(0, 0);
                        head->next = tail;
                        tail->prev = head;
                        size = 0;
                    }

                    void addToHead(ListNode* node) {
                        node->prev = head;
                        node->next = head->next;
                        head->next->prev = node;
                        head->next = node;
                        size++;
                    }

                    void moveToHead(ListNode* node) {
                        remove(node);
                        addToHead(node);
                    }

                    ListNode* removeTail() {
                        ListNode* res = tail->prev;
                        remove(res);
                        return res;
                    }

                    void remove(ListNode* node) {
                        node->prev->next = node->next;
                        node->next->prev = node->prev;
                        size--;
                    }
                };

                class ListNode {
                public:
                    int key, val;
                    ListNode* prev;
                    ListNode* next;

                    ListNode(int key, int val) {
                        this->key = key;
                        this->val = val;
                    }
                };
            """.trimIndent()
            )
        ) // done
    ), Topic(
        topicName = "Recursion",
        topicDetails = "Problems solved using recursive algorithms",
        questions = listOf(
            Question(
                name = "Fibonacci Number",
                link = "https://leetcode.com/problems/fibonacci-number/",
                solutionJava = """
                class Fibonacci {
                    public int fib(int n) {
                        if (n <= 1) return n;
                        return fib(n - 1) + fib(n - 2);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int fib(int n) {
                        if (n <= 1) return n;
                        return fib(n - 1) + fib(n - 2);
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Pow(x, n)",
                link = "https://leetcode.com/problems/powx-n/",
                solutionJava = """
                class Solution {
                    public double myPow(double x, int n) {
                        if (n == 0) return 1;
                        if (n < 0) return 1 / myPow(x, -n);
                        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, (n - 1) / 2);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    double myPow(double x, int n) {
                        if (n == 0) return 1;
                        if (n < 0) return 1 / myPow(x, -n);
                        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, (n - 1) / 2);
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Reverse String",
                link = "https://leetcode.com/problems/reverse-string/",
                solutionJava = """
                class Solution {
                    public void reverseString(char[] s) {
                        reverse(s, 0, s.length - 1);
                    }
                    private void reverse(char[] s, int left, int right) {
                        if (left < right) {
                            char temp = s[left];
                            s[left] = s[right];
                            s[right] = temp;
                            reverse(s, left + 1, right - 1);
                        }
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    void reverseString(vector<char>& s) {
                        reverse(s, 0, s.size() - 1);
                    }
                private:
                    void reverse(vector<char>& s, int left, int right) {
                        if (left < right) {
                            swap(s[left], s[right]);
                            reverse(s, left + 1, right - 1);
                        }
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Subsets",
                link = "https://leetcode.com/problems/subsets/",
                solutionJava = """
                class Solution {
                    public List<List<Integer>> subsets(int[] nums) {
                        List<List<Integer>> result = new ArrayList<>();
                        backtrack(result, new ArrayList<>(), nums, 0);
                        return result;
                    }
                    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
                        result.add(new ArrayList<>(tempList));
                        for (int i = start; i < nums.length; i++) {
                            tempList.add(nums[i]);
                            backtrack(result, tempList, nums, i + 1);
                            tempList.remove(tempList.size() - 1);
                        }
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<vector<int>> subsets(vector<int>& nums) {
                        vector<vector<int>> result;
                        vector<int> tempList;
                        backtrack(result, tempList, nums, 0);
                        return result;
                    }
                private:
                    void backtrack(vector<vector<int>>& result, vector<int>& tempList, vector<int>& nums, int start) {
                        result.push_back(tempList);
                        for (int i = start; i < nums.size(); i++) {
                            tempList.push_back(nums[i]);
                            backtrack(result, tempList, nums, i + 1);
                            tempList.pop_back();
                        }
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Permutations",
                link = "https://leetcode.com/problems/permutations/",
                solutionJava = """
                class Solution {
                    public List<List<Integer>> permute(int[] nums) {
                        List<List<Integer>> result = new ArrayList<>();
                        backtrack(result, new ArrayList<>(), nums);
                        return result;
                    }
                    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
                        if (tempList.size() == nums.length) {
                            result.add(new ArrayList<>(tempList));
                        } else {
                            for (int i = 0; i < nums.length; i++) {
                                if (tempList.contains(nums[i])) continue; // skip duplicates
                                tempList.add(nums[i]);
                                backtrack(result, tempList, nums);
                                tempList.remove(tempList.size() - 1);
                            }
                        }
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<vector<int>> permute(vector<int>& nums) {
                        vector<vector<int>> result;
                        vector<int> tempList;
                        backtrack(result, tempList, nums);
                        return result;
                    }
                private:
                    void backtrack(vector<vector<int>>& result, vector<int>& tempList, vector<int>& nums) {
                        if (tempList.size() == nums.size()) {
                            result.push_back(tempList);
                        } else {
                            for (int i = 0; i < nums.size(); i++) {
                                if (find(tempList.begin(), tempList.end(), nums[i]) != tempList.end()) continue; // skip duplicates
                                tempList.push_back(nums[i]);
                                backtrack(result, tempList, nums);
                                tempList.pop_back();
                            }
                        }
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Generate Parentheses",
                link = "https://leetcode.com/problems/generate-parentheses/",
                solutionJava = """
                class Solution {
                    public List<String> generateParenthesis(int n) {
                        List<String> result = new ArrayList<>();
                        backtrack(result, "", 0, 0, n);
                        return result;
                    }
                    private void backtrack(List<String> result, String current, int open, int close, int max) {
                        if (current.length() == max * 2) {
                            result.add(current);
                            return;
                        }
                        if (open < max) backtrack(result, current + "(", open + 1, close, max);
                        if (close < open) backtrack(result, current + ")", open, close + 1, max);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<string> generateParenthesis(int n) {
                        vector<string> result;
                        backtrack(result, "", 0, 0, n);
                        return result;
                    }
                private:
                    void backtrack(vector<string>& result, string current, int open, int close, int max) {
                        if (current.length() == max * 2) {
                            result.push_back(current);
                            return;
                        }
                        if (open < max) backtrack(result, current + "(", open + 1, close, max);
                        if (close < open) backtrack(result, current + ")", open, close + 1, max);
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Merge Two Sorted Lists",
                link = "https://leetcode.com/problems/merge-two-sorted-lists/",
                solutionJava = """
                class Solution {
                    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
                        if (l1 == null) return l2;
                        if (l2 == null) return l1;
                        if (l1.val < l2.val) {
                            l1.next = mergeTwoLists(l1.next, l2);
                            return l1;
                        } else {
                            l2.next = mergeTwoLists(l1, l2.next);
                            return l2;
                        }
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
                        if (!l1) return l2;
                        if (!l2) return l1;
                        if (l1->val < l2->val) {
                            l1->next = mergeTwoLists(l1->next, l2);
                            return l1;
                        } else {
                            l2->next = mergeTwoLists(l1, l2->next);
                            return l2;
                        }
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "K-th Symbol in Grammar",
                link = "https://leetcode.com/problems/k-th-symbol-in-grammar/",
                solutionJava = """
                class Solution {
                    public int kthGrammar(int n, int k) {
                        if (n == 1) return 0;
                        if (k % 2 == 0) return 1 - kthGrammar(n - 1, (k / 2));
                        return kthGrammar(n - 1, (k + 1) / 2);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int kthGrammar(int n, int k) {
                        if (n == 1) return 0;
                        if (k % 2 == 0) return 1 - kthGrammar(n - 1, k / 2);
                        return kthGrammar(n - 1, (k + 1) / 2);
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Climbing Stairs",
                link = "https://leetcode.com/problems/climbing-stairs/",
                solutionJava = """
                class Solution {
                    public int climbStairs(int n) {
                        return climb(n);
                    }
                    private int climb(int n) {
                        if (n <= 1) return 1;
                        return climb(n - 1) + climb(n - 2);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int climbStairs(int n) {
                        return climb(n);
                    }
                private:
                    int climb(int n) {
                        if (n <= 1) return 1;
                        return climb(n - 1) + climb(n - 2);
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "N-Queens",
                link = "https://leetcode.com/problems/n-queens/",
                solutionJava = """
                class Solution {
                    public List<List<String>> solveNQueens(int n) {
                        List<List<String>> result = new ArrayList<>();
                        backtrack(result, new ArrayList<>(), new boolean[n], new boolean[n * 2], new boolean[n * 2], n);
                        return result;
                    }
                    private void backtrack(List<List<String>> result, List<String> temp, boolean[] cols, boolean[] diag1, boolean[] diag2, int n) {
                        if (temp.size() == n) {
                            result.add(new ArrayList<>(temp));
                            return;
                        }
                        for (int col = 0; col < n; col++) {
                            if (cols[col] || diag1[temp.size() + col] || diag2[temp.size() - col + n]) continue;
                            temp.add(buildRow(col, n));
                            cols[col] = diag1[temp.size() + col] = diag2[temp.size() - col + n] = true;
                            backtrack(result, temp, cols, diag1, diag2, n);
                            temp.remove(temp.size() - 1);
                            cols[col] = diag1[temp.size() + col] = diag2[temp.size() - col + n] = false;
                        }
                    }
                    private String buildRow(int col, int n) {
                        char[] row = new char[n];
                        Arrays.fill(row, '.');
                        row[col] = 'Q';
                        return new String(row);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<vector<string>> solveNQueens(int n) {
                        vector<vector<string>> result;
                        vector<string> temp(n, string(n, '.'));
                        vector<bool> cols(n), diag1(2 * n), diag2(2 * n);
                        backtrack(result, temp, cols, diag1, diag2, n, 0);
                        return result;
                    }
                private:
                    void backtrack(vector<vector<string>>& result, vector<string>& temp, vector<bool>& cols, vector<bool>& diag1, vector<bool>& diag2, int n, int row) {
                        if (row == n) {
                            result.push_back(temp);
                            return;
                        }
                        for (int col = 0; col < n; col++) {
                            if (cols[col] || diag1[row + col] || diag2[row - col + n]) continue;
                            temp[row][col] = 'Q';
                            cols[col] = diag1[row + col] = diag2[row - col + n] = true;
                            backtrack(result, temp, cols, diag1, diag2, n, row + 1);
                            temp[row][col] = '.';
                            cols[col] = diag1[row + col] = diag2[row - col + n] = false;
                        }
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Sudoku Solver",
                link = "https://leetcode.com/problems/sudoku-solver/",
                solutionJava = """
                class Solution {
                    public void solveSudoku(char[][] board) {
                        backtrack(board);
                    }
                    private boolean backtrack(char[][] board) {
                        for (int row = 0; row < 9; row++) {
                            for (int col = 0; col < 9; col++) {
                                if (board[row][col] == '.') {
                                    for (char num = '1'; num <= '9'; num++) {
                                        if (isValid(board, row, col, num)) {
                                            board[row][col] = num;
                                            if (backtrack(board)) return true;
                                            board[row][col] = '.'; // backtrack
                                        }
                                    }
                                    return false; // No valid number found
                                }
                            }
                        }
                        return true; // Solved
                    }
                    private boolean isValid(char[][] board, int row, int col, char num) {
                        for (int i = 0; i < 9; i++) {
                            if (board[row][i] == num || board[i][col] == num || 
                                board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == num) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    void solveSudoku(vector<vector<char>>& board) {
                        backtrack(board);
                    }
                private:
                    bool backtrack(vector<vector<char>>& board) {
                        for (int row = 0; row < 9; row++) {
                            for (int col = 0; col < 9; col++) {
                                if (board[row][col] == '.') {
                                    for (char num = '1'; num <= '9'; num++) {
                                        if (isValid(board, row, col, num)) {
                                            board[row][col] = num;
                                            if (backtrack(board)) return true;
                                            board[row][col] = '.'; // backtrack
                                        }
                                    }
                                    return false; // No valid number found
                                }
                            }
                        }
                        return true; // Solved
                    }
                    bool isValid(vector<vector<char>>& board, int row, int col, char num) {
                        for (int i = 0; i < 9; i++) {
                            if (board[row][i] == num || board[i][col] == num || 
                                board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == num) {
                                return false;
                            }
                        }
                        return true;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Combination Sum",
                link = "https://leetcode.com/problems/combination-sum/",
                solutionJava = """
                class Solution {
                    public List<List<Integer>> combinationSum(int[] candidates, int target) {
                        List<List<Integer>> result = new ArrayList<>();
                        backtrack(result, new ArrayList<>(), candidates, target, 0);
                        return result;
                    }
                    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
                        if (remain < 0) return;
                        if (remain == 0) result.add(new ArrayList<>(tempList));
                        for (int i = start; i < candidates.length; i++) {
                            tempList.add(candidates[i]);
                            backtrack(result, tempList, candidates, remain - candidates[i], i);
                            tempList.remove(tempList.size() - 1);
                        }
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
                        vector<vector<int>> result;
                        vector<int> tempList;
                        backtrack(result, tempList, candidates, target, 0);
                        return result;
                    }
                private:
                    void backtrack(vector<vector<int>>& result, vector<int>& tempList, vector<int>& candidates, int remain, int start) {
                        if (remain < 0) return;
                        if (remain == 0) result.push_back(tempList);
                        for (int i = start; i < candidates.size(); i++) {
                            tempList.push_back(candidates[i]);
                            backtrack(result, tempList, candidates, remain - candidates[i], i);
                            tempList.pop_back();
                        }
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Word Search",
                link = "https://leetcode.com/problems/word-search/",
                solutionJava = """
                class Solution {
                    public boolean exist(char[][] board, String word) {
                        for (int i = 0; i < board.length; i++) {
                            for (int j = 0; j < board[0].length; j++) {
                                if (backtrack(board, word, i, j, 0)) return true;
                            }
                        }
                        return false;
                    }
                    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
                        if (index == word.length()) return true;
                        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
                            return false;
                        }
                        char temp = board[i][j];
                        board[i][j] = '#'; // mark as visited
                        boolean found = backtrack(board, word, i + 1, j, index + 1) ||
                                        backtrack(board, word, i - 1, j, index + 1) ||
                                        backtrack(board, word, i, j + 1, index + 1) ||
                                        backtrack(board, word, i, j - 1, index + 1);
                        board[i][j] = temp; // unmark
                        return found;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    bool exist(vector<vector<char>>& board, string word) {
                        for (int i = 0; i < board.size(); i++) {
                            for (int j = 0; j < board[0].size(); j++) {
                                if (backtrack(board, word, i, j, 0)) return true;
                            }
                        }
                        return false;
                    }
                private:
                    bool backtrack(vector<vector<char>>& board, string& word, int i, int j, int index) {
                        if (index == word.length()) return true;
                        if (i < 0 || j < 0 || i >= board.size() || j >= board[0].size() || board[i][j] != word[index]) {
                            return false;
                        }
                        char temp = board[i][j];
                        board[i][j] = '#'; // mark as visited
                        bool found = backtrack(board, word, i + 1, j, index + 1) ||
                                     backtrack(board, word, i - 1, j, index + 1) ||
                                     backtrack(board, word, i, j + 1, index + 1) ||
                                     backtrack(board, word, i, j - 1, index + 1);
                        board[i][j] = temp; // unmark
                        return found;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Letter Combinations of a Phone Number",
                link = "https://leetcode.com/problems/letter-combinations-of-a-phone-number/",
                solutionJava = """
                class Solution {
                    public List<String> letterCombinations(String digits) {
                        List<String> result = new ArrayList<>();
                        if (digits.isEmpty()) return result;
                        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
                        backtrack(result, new StringBuilder(), digits, mapping, 0);
                        return result;
                    }
                    private void backtrack(List<String> result, StringBuilder temp, String digits, String[] mapping, int index) {
                        if (index == digits.length()) {
                            result.add(temp.toString());
                            return;
                        }
                        String letters = mapping[digits.charAt(index) - '0'];
                        for (char c : letters.toCharArray()) {
                            temp.append(c);
                            backtrack(result, temp, digits, mapping, index + 1);
                            temp.deleteCharAt(temp.length() - 1);
                        }
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<string> letterCombinations(string digits) {
                        vector<string> result;
                        if (digits.empty()) return result;
                        vector<string> mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
                        string temp;
                        backtrack(result, temp, digits, mapping, 0);
                        return result;
                    }
                private:
                    void backtrack(vector<string>& result, string& temp, string& digits, vector<string>& mapping, int index) {
                        if (index == digits.length()) {
                            result.push_back(temp);
                            return;
                        }
                        string letters = mapping[digits[index] - '0'];
                        for (char c : letters) {
                            temp.push_back(c);
                            backtrack(result, temp, digits, mapping, index + 1);
                            temp.pop_back();
                        }
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Regular Expression Matching",
                link = "https://leetcode.com/problems/regular-expression-matching/",
                solutionJava = """
                class Solution {
                    public boolean isMatch(String s, String p) {
                        return backtrack(s, p, 0, 0);
                    }
                    private boolean backtrack(String s, String p, int i, int j) {
                        if (j == p.length()) return i == s.length();
                        boolean firstMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
                        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                            return (firstMatch && backtrack(s, p, i + 1, j)) || backtrack(s, p, i, j + 2);
                        }
                        return firstMatch && backtrack(s, p, i + 1, j + 1);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    bool isMatch(string s, string p) {
                        return backtrack(s, p, 0, 0);
                    }
                private:
                    bool backtrack(string& s, string& p, int i, int j) {
                        if (j == p.length()) return i == s.length();
                        bool firstMatch = (i < s.length() && (s[i] == p[j] || p[j] == '.'));
                        if (j + 1 < p.length() && p[j + 1] == '*') {
                            return (firstMatch && backtrack(s, p, i + 1, j)) || backtrack(s, p, i, j + 2);
                        }
                        return firstMatch && backtrack(s, p, i + 1, j + 1);
                    }
                };
            """.trimIndent()
            )
        ) // done
    ), Topic(
        topicName = "Bit Manipulation",
        topicDetails = "Problems involving bitwise operations",
        questions = listOf(
            Question(
                name = "Single Number",
                link = "https://leetcode.com/problems/single-number/",
                solutionJava = """
                class SingleNumber {
                    public int singleNumber(int[] nums) {
                        int unique = 0;
                        for (int num : nums) {
                            unique ^= num;
                        }
                        return unique;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int singleNumber(vector<int>& nums) {
                        int unique = 0;
                        for (int num : nums) {
                            unique ^= num;
                        }
                        return unique;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Number of 1 Bits",
                link = "https://leetcode.com/problems/number-of-1-bits/",
                solutionJava = """
                class NumberOf1Bits {
                    public int hammingWeight(int n) {
                        int count = 0;
                        while (n != 0) {
                            count += n & 1;
                            n >>>= 1;
                        }
                        return count;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int hammingWeight(uint32_t n) {
                        int count = 0;
                        while (n) {
                            count += n & 1;
                            n >>= 1;
                        }
                        return count;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Counting Bits",
                link = "https://leetcode.com/problems/counting-bits/",
                solutionJava = """
                class CountingBits {
                    public int[] countBits(int n) {
                        int[] res = new int[n + 1];
                        for (int i = 1; i <= n; i++) {
                            res[i] = res[i >> 1] + (i & 1);
                        }
                        return res;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<int> countBits(int n) {
                        vector<int> res(n + 1);
                        for (int i = 1; i <= n; i++) {
                            res[i] = res[i >> 1] + (i & 1);
                        }
                        return res;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Reverse Bits",
                link = "https://leetcode.com/problems/reverse-bits/",
                solutionJava = """
                class ReverseBits {
                    public int reverseBits(int n) {
                        int result = 0;
                        for (int i = 0; i < 32; i++) {
                            result = (result << 1) | (n & 1);
                            n >>= 1;
                        }
                        return result;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    uint32_t reverseBits(uint32_t n) {
                        uint32_t result = 0;
                        for (int i = 0; i < 32; i++) {
                            result = (result << 1) | (n & 1);
                            n >>= 1;
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Power of Two",
                link = "https://leetcode.com/problems/power-of-two/",
                solutionJava = """
                class PowerOfTwo {
                    public boolean isPowerOfTwo(int n) {
                        return n > 0 && (n & (n - 1)) == 0;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    bool isPowerOfTwo(int n) {
                        return n > 0 && (n & (n - 1)) == 0;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Hamming Distance",
                link = "https://leetcode.com/problems/hamming-distance/",
                solutionJava = """
                class HammingDistance {
                    public int hammingDistance(int x, int y) {
                        return Integer.bitCount(x ^ y);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int hammingDistance(int x, int y) {
                        return __builtin_popcount(x ^ y);
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Sum of Two Integers",
                link = "https://leetcode.com/problems/sum-of-two-integers/",
                solutionJava = """
                class SumOfTwoIntegers {
                    public int getSum(int a, int b) {
                        while (b != 0) {
                            int carry = a & b;
                            a ^= b;
                            b = carry << 1;
                        }
                        return a;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int getSum(int a, int b) {
                        while (b != 0) {
                            int carry = a & b;
                            a ^= b;
                            b = carry << 1;
                        }
                        return a;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Missing Number",
                link = "https://leetcode.com/problems/missing-number/",
                solutionJava = """
                class MissingNumber {
                    public int missingNumber(int[] nums) {
                        int n = nums.length;
                        int sum = n * (n + 1) / 2;
                        for (int num : nums) {
                            sum -= num;
                        }
                        return sum;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int missingNumber(vector<int>& nums) {
                        int n = nums.size(), sum = n * (n + 1) / 2;
                        for (int num : nums) {
                            sum -= num;
                        }
                        return sum;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Bitwise AND of Numbers Range",
                link = "https://leetcode.com/problems/bitwise-and-of-numbers-range/",
                solutionJava = """
                class BitwiseAND {
                    public int rangeBitwiseAnd(int m, int n) {
                        int shift = 0;
                        while (m < n) {
                            m >>= 1;
                            n >>= 1;
                            shift++;
                        }
                        return m << shift;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int rangeBitwiseAnd(int m, int n) {
                        int shift = 0;
                        while (m < n) {
                            m >>= 1;
                            n >>= 1;
                            shift++;
                        }
                        return m << shift;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Single Number II",
                link = "https://leetcode.com/problems/single-number-ii/",
                solutionJava = """
                class SingleNumberII {
                    public int singleNumber(int[] nums) {
                        int[] count = new int[32];
                        for (int num : nums) {
                            for (int i = 0; i < 32; i++) {
                                count[i] += (num >> i) & 1;
                            }
                        }
                        int result = 0;
                        for (int i = 0; i < 32; i++) {
                            result |= (count[i] % 3) << i;
                        }
                        return result;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int singleNumber(vector<int>& nums) {
                        vector<int> count(32);
                        for (int num : nums) {
                            for (int i = 0; i < 32; i++) {
                                count[i] += (num >> i) & 1;
                            }
                        }
                        int result = 0;
                        for (int i = 0; i < 32; i++) {
                            result |= (count[i] % 3) << i;
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Single Number III",
                link = "https://leetcode.com/problems/single-number-iii/",
                solutionJava = """
                class SingleNumberIII {
                    public int[] singleNumber(int[] nums) {
                        int xor = 0;
                        for (int num : nums) {
                            xor ^= num;
                        }
                        int diffBit = xor & -xor;
                        int[] result = new int[2];
                        for (int num : nums) {
                            if ((num & diffBit) == 0) {
                                result[0] ^= num;
                            } else {
                                result[1] ^= num;
                            }
                        }
                        return result;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<int> singleNumber(vector<int>& nums) {
                        int xor = 0;
                        for (int num : nums) {
                            xor ^= num;
                        }
                        int diffBit = xor & -xor;
                        vector<int> result(2, 0);
                        for (int num : nums) {
                            if ((num & diffBit) == 0) {
                                result[0] ^= num;
                            } else {
                                result[1] ^= num;
                            }
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "UTF-8 Validation",
                link = "https://leetcode.com/problems/utf-8-validation/",
                solutionJava = """
                class UTF8Validation {
                    public boolean validUtf8(int[] data) {
                        int numBytes = 0;
                        for (int num : data) {
                            if (num >= 128) {
                                if (numBytes == 0) {
                                    if ((num >> 5) == 0b110) {
                                        numBytes = 1;
                                    } else if ((num >> 4) == 0b1110) {
                                        numBytes = 2;
                                    } else if ((num >> 3) == 0b11110) {
                                        numBytes = 3;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    if ((num >> 6) != 0b10) {
                                        return false;
                                    }
                                }
                            } else {
                                if (numBytes > 0) {
                                    numBytes--;
                                }
                            }
                        }
                        return numBytes == 0;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    bool validUtf8(vector<int>& data) {
                        int numBytes = 0;
                        for (int num : data) {
                            if (num >= 128) {
                                if (numBytes == 0) {
                                    if ((num >> 5) == 0b110) {
                                        numBytes = 1;
                                    } else if ((num >> 4) == 0b1110) {
                                        numBytes = 2;
                                    } else if ((num >> 3) == 0b11110) {
                                        numBytes = 3;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    if ((num >> 6) != 0b10) {
                                        return false;
                                    }
                                }
                            } else {
                                if (numBytes > 0) {
                                    numBytes--;
                                }
                            }
                        }
                        return numBytes == 0;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Divide Two Integers",
                link = "https://leetcode.com/problems/divide-two-integers/",
                solutionJava = """
                class DivideTwoIntegers {
                    public int divide(int dividend, int divisor) {
                        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
                        long dvd = Math.abs((long) dividend);
                        long dvs = Math.abs((long) divisor);
                        int quotient = 0;
                        while (dvd >= dvs) {
                            long temp = dvs, multiple = 1;
                            while (dvd >= (temp << 1)) {
                                temp <<= 1;
                                multiple <<= 1;
                            }
                            dvd -= temp;
                            quotient += multiple;
                        }
                        return (dividend > 0) ^ (divisor > 0) ? -quotient : quotient;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int divide(int dividend, int divisor) {
                        if (dividend == INT_MIN && divisor == -1) return INT_MAX;
                        long dvd = labs(dividend), dvs = labs(divisor), quotient = 0;
                        while (dvd >= dvs) {
                            long temp = dvs, multiple = 1;
                            while (dvd >= (temp << 1)) {
                                temp <<= 1;
                                multiple <<= 1;
                            }
                            dvd -= temp;
                            quotient += multiple;
                        }
                        return (dividend > 0) ^ (divisor > 0) ? -quotient : quotient;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Subsets",
                link = "https://leetcode.com/problems/subsets/",
                solutionJava = """
                class Subsets {
                    public List<List<Integer>> subsets(int[] nums) {
                        List<List<Integer>> result = new ArrayList<>();
                        result.add(new ArrayList<>());
                        for (int num : nums) {
                            int n = result.size();
                            for (int i = 0; i < n; i++) {
                                List<Integer> subset = new ArrayList<>(result.get(i));
                                subset.add(num);
                                result.add(subset);
                            }
                        }
                        return result;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<vector<int>> subsets(vector<int>& nums) {
                        vector<vector<int>> result = {{}};
                        for (int num : nums) {
                            int n = result.size();
                            for (int i = 0; i < n; i++) {
                                vector<int> subset = result[i];
                                subset.push_back(num);
                                result.push_back(subset);
                            }
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Majority Element",
                link = "https://leetcode.com/problems/majority-element/",
                solutionJava = """
                class MajorityElement {
                    public int majorityElement(int[] nums) {
                        int count = 0, candidate = 0;
                        for (int num : nums) {
                            if (count == 0) candidate = num;
                            count += (num == candidate) ? 1 : -1;
                        }
                        return candidate;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int majorityElement(vector<int>& nums) {
                        int count = 0, candidate = 0;
                        for (int num : nums) {
                            if (count == 0) candidate = num;
                            count += (num == candidate) ? 1 : -1;
                        }
                        return candidate;
                    }
                };
            """.trimIndent()
            )
        ) // done
    ), Topic(
        topicName = "Stack and Queues",
        topicDetails = "Problems involving stack and queue data structures",
        questions = listOf(
            Question(
                "Valid Parentheses",
                "https://leetcode.com/problems/valid-parentheses/",
                solutionJava = """
                class ValidParentheses {
                    public boolean isValid(String s) {
                        Stack<Character> stack = new Stack<>();
                        for (char c : s.toCharArray()) {
                            if (c == '(' || c == '{' || c == '[') {
                                stack.push(c);
                            } else {
                                if (stack.isEmpty()) return false;
                                char top = stack.pop();
                                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                                    return false;
                                }
                            }
                        }
                        return stack.isEmpty();
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    bool isValid(string s) {
                        stack<char> stack;
                        for (char c : s) {
                            if (c == '(' || c == '{' || c == '[') {
                                stack.push(c);
                            } else {
                                if (stack.empty()) return false;
                                char top = stack.top();
                                stack.pop();
                                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                                    return false;
                                }
                            }
                        }
                        return stack.empty();
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Min Stack",
                "https://leetcode.com/problems/min-stack/",
                solutionJava = """
                class MinStack {
                    private Stack<Integer> stack;
                    private Stack<Integer> minStack;

                    public MinStack() {
                        stack = new Stack<>();
                        minStack = new Stack<>();
                    }

                    public void push(int x) {
                        stack.push(x);
                        if (minStack.isEmpty() || x <= minStack.peek()) {
                            minStack.push(x);
                        }
                    }

                    public void pop() {
                        int top = stack.pop();
                        if (top == minStack.peek()) {
                            minStack.pop();
                        }
                    }

                    public int top() {
                        return stack.peek();
                    }

                    public int getMin() {
                        return minStack.peek();
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class MinStack {
                    stack<int> s;
                    stack<int> min_s;

                public:
                    MinStack() {}

                    void push(int x) {
                        s.push(x);
                        if (min_s.empty() || x <= min_s.top()) {
                            min_s.push(x);
                        }
                    }

                    void pop() {
                        if (s.top() == min_s.top()) {
                            min_s.pop();
                        }
                        s.pop();
                    }

                    int top() {
                        return s.top();
                    }

                    int getMin() {
                        return min_s.top();
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Implement Queue using Stacks",
                "https://leetcode.com/problems/implement-queue-using-stacks/",
                solutionJava = """
                class MyQueue {
                    private Stack<Integer> stack1;
                    private Stack<Integer> stack2;

                    public MyQueue() {
                        stack1 = new Stack<>();
                        stack2 = new Stack<>();
                    }

                    public void push(int x) {
                        stack1.push(x);
                    }

                    public int pop() {
                        if (stack2.isEmpty()) {
                            while (!stack1.isEmpty()) {
                                stack2.push(stack1.pop());
                            }
                        }
                        return stack2.pop();
                    }

                    public int peek() {
                        if (stack2.isEmpty()) {
                            while (!stack1.isEmpty()) {
                                stack2.push(stack1.pop());
                            }
                        }
                        return stack2.peek();
                    }

                    public boolean empty() {
                        return stack1.isEmpty() && stack2.isEmpty();
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class MyQueue {
                    stack<int> s1, s2;

                public:
                    MyQueue() {}

                    void push(int x) {
                        s1.push(x);
                    }

                    int pop() {
                        if (s2.empty()) {
                            while (!s1.empty()) {
                                s2.push(s1.top());
                                s1.pop();
                            }
                        }
                        int val = s2.top();
                        s2.pop();
                        return val;
                    }

                    int peek() {
                        if (s2.empty()) {
                            while (!s1.empty()) {
                                s2.push(s1.top());
                                s1.pop();
                            }
                        }
                        return s2.top();
                    }

                    bool empty() {
                        return s1.empty() && s2.empty();
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Implement Stack using Queues",
                "https://leetcode.com/problems/implement-stack-using-queues/",
                solutionJava = """
                class MyStack {
                    private Queue<Integer> queue;

                    public MyStack() {
                        queue = new LinkedList<>();
                    }

                    public void push(int x) {
                        queue.offer(x);
                        for (int i = 1; i < queue.size(); i++) {
                            queue.offer(queue.poll());
                        }
                    }

                    public int pop() {
                        return queue.poll();
                    }

                    public int top() {
                        return queue.peek();
                    }

                    public boolean empty() {
                        return queue.isEmpty();
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class MyStack {
                    queue<int> q;

                public:
                    MyStack() {}

                    void push(int x) {
                        q.push(x);
                        for (int i = 1; i < q.size(); i++) {
                            q.push(q.front());
                            q.pop();
                        }
                    }

                    int pop() {
                        int val = q.front();
                        q.pop();
                        return val;
                    }

                    int top() {
                        return q.front();
                    }

                    bool empty() {
                        return q.empty();
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Evaluate Reverse Polish Notation",
                "https://leetcode.com/problems/evaluate-reverse-polish-notation/",
                solutionJava = """
                class Solution {
                    public int evalRPN(String[] tokens) {
                        Stack<Integer> stack = new Stack<>();
                        for (String token : tokens) {
                            if (token.equals("+")) {
                                int b = stack.pop();
                                int a = stack.pop();
                                stack.push(a + b);
                            } else if (token.equals("-")) {
                                int b = stack.pop();
                                int a = stack.pop();
                                stack.push(a - b);
                            } else if (token.equals("*")) {
                                int b = stack.pop();
                                int a = stack.pop();
                                stack.push(a * b);
                            } else if (token.equals("/")) {
                                int b = stack.pop();
                                int a = stack.pop();
                                stack.push(a / b);
                            } else {
                                stack.push(Integer.parseInt(token));
                            }
                        }
                        return stack.pop();
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int evalRPN(vector<string>& tokens) {
                        stack<int> stack;
                        for (const string& token : tokens) {
                            if (token == "+" || token == "-" || token == "*" || token == "/") {
                                int b = stack.top(); stack.pop();
                                int a = stack.top(); stack.pop();
                                if (token == "+") stack.push(a + b);
                                else if (token == "-") stack.push(a - b);
                                else if (token == "*") stack.push(a * b);
                                else stack.push(a / b);
                            } else {
                                stack.push(stoi(token));
                            }
                        }
                        return stack.top();
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Daily Temperatures",
                "https://leetcode.com/problems/daily-temperatures/",
                solutionJava = """
                class Solution {
                    public int[] dailyTemperatures(int[] T) {
                        int n = T.length;
                        int[] res = new int[n];
                        Stack<Integer> stack = new Stack<>();
                        for (int i = 0; i < n; i++) {
                            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                                int j = stack.pop();
                                res[j] = i - j;
                            }
                            stack.push(i);
                        }
                        return res;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<int> dailyTemperatures(vector<int>& T) {
                        int n = T.size();
                        vector<int> res(n, 0);
                        stack<int> stack;
                        for (int i = 0; i < n; i++) {
                            while (!stack.empty() && T[i] > T[stack.top()]) {
                                int j = stack.top();
                                stack.pop();
                                res[j] = i - j;
                            }
                            stack.push(i);
                        }
                        return res;
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Next Greater Element I",
                "https://leetcode.com/problems/next-greater-element-i/",
                solutionJava = """
        class Solution {
            public int[] nextGreaterElement(int[] nums1, int[] nums2) {
                Map<Integer, Integer> map = new HashMap<>();
                Stack<Integer> stack = new Stack<>();
                for (int num : nums2) {
                    while (!stack.isEmpty() && stack.peek() < num) {
                        map.put(stack.pop(), num);
                    }
                    stack.push(num);
                }
                int[] res = new int[nums1.length];
                for (int i = 0; i < nums1.length; i++) {
                    res[i] = map.getOrDefault(nums1[i], -1);
                }
                return res;
            }
        }
    """.trimIndent(),
                solutionCpp = """
        class Solution {
        public:
            vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
                unordered_map<int, int> map;
                stack<int> stack;
                for (int num : nums2) {
                    while (!stack.empty() && stack.top() < num) {
                        map[stack.top()] = num;
                        stack.pop();
                    }
                    stack.push(num);
                }
                vector<int> res;
                for (int num : nums1) {
                    res.push_back(map.count(num) ? map[num] : -1);
                }
                return res;
            }
        };
    """.trimIndent()
            ),
            Question(
                "Backspace String Compare",
                "https://leetcode.com/problems/backspace-string-compare/",
                solutionJava = """
                class Solution {
                    public boolean backspaceCompare(String s, String t) {
                        return build(s).equals(build(t));
                    }

                    private String build(String str) {
                        Stack<Character> stack = new Stack<>();
                        for (char c : str.toCharArray()) {
                            if (c != '#') {
                                stack.push(c);
                            } else if (!stack.isEmpty()) {
                                stack.pop();
                            }
                        }
                        return String.valueOf(stack);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    bool backspaceCompare(string s, string t) {
                        return build(s) == build(t);
                    }
                    
                private:
                    string build(const string& str) {
                        stack<char> stack;
                        for (char c : str) {
                            if (c != '#') {
                                stack.push(c);
                            } else if (!stack.empty()) {
                                stack.pop();
                            }
                        }
                        string result;
                        while (!stack.empty()) {
                            result += stack.top();
                            stack.pop();
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Remove All Adjacent Duplicates In String",
                "https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/",
                solutionJava = """
                class Solution {
                    public String removeDuplicates(String s) {
                        Stack<Character> stack = new Stack<>();
                        for (char c : s.toCharArray()) {
                            if (!stack.isEmpty() && stack.peek() == c) {
                                stack.pop();
                            } else {
                                stack.push(c);
                            }
                        }
                        StringBuilder result = new StringBuilder();
                        for (char c : stack) result.append(c);
                        return result.toString();
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    string removeDuplicates(string s) {
                        stack<char> stack;
                        for (char c : s) {
                            if (!stack.empty() && stack.top() == c) {
                                stack.pop();
                            } else {
                                stack.push(c);
                            }
                        }
                        string result;
                        while (!stack.empty()) {
                            result = stack.top() + result;
                            stack.pop();
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Asteroid Collision",
                "https://leetcode.com/problems/asteroid-collision/",
                solutionJava = """
                class Solution {
                    public int[] asteroidCollision(int[] asteroids) {
                        Stack<Integer> stack = new Stack<>();
                        for (int a : asteroids) {
                            collision: {
                                while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                                    if (stack.peek() < -a) {
                                        stack.pop();
                                        continue;
                                    } else if (stack.peek() == -a) {
                                        stack.pop();
                                    }
                                    break collision;
                                }
                                stack.push(a);
                            }
                        }
                        return stack.stream().mapToInt(i -> i).toArray();
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<int> asteroidCollision(vector<int>& asteroids) {
                        stack<int> stack;
                        for (int a : asteroids) {
                            bool exploded = false;
                            while (!stack.empty() && a < 0 && stack.top() > 0) {
                                if (stack.top() < -a) {
                                    stack.pop();
                                    continue;
                                } else if (stack.top() == -a) {
                                    stack.pop();
                                }
                                exploded = true;
                                break;
                            }
                            if (!exploded) stack.push(a);
                        }
                        return vector<int>(stack.begin(), stack.end());
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Basic Calculator",
                "https://leetcode.com/problems/basic-calculator/",
                solutionJava = """
                class Solution {
                    public int calculate(String s) {
                        Stack<Integer> stack = new Stack<>();
                        int result = 0, sign = 1;
                        for (int i = 0; i < s.length(); i++) {
                            char c = s.charAt(i);
                            if (Character.isDigit(c)) {
                                int num = c - '0';
                                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                                    num = num * 10 + (s.charAt(++i) - '0');
                                }
                                result += num * sign;
                            } else if (c == '+') {
                                sign = 1;
                            } else if (c == '-') {
                                sign = -1;
                            } else if (c == '(') {
                                stack.push(result);
                                stack.push(sign);
                                result = 0;
                                sign = 1;
                            } else if (c == ')') {
                                result = result * stack.pop() + stack.pop();
                            }
                        }
                        return result;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int calculate(string s) {
                        stack<int> stack;
                        int result = 0, sign = 1;
                        for (int i = 0; i < s.size(); i++) {
                            char c = s[i];
                            if (isdigit(c)) {
                                int num = c - '0';
                                while (i + 1 < s.size() && isdigit(s[i + 1])) {
                                    num = num * 10 + (s[++i] - '0');
                                }
                                result += num * sign;
                            } else if (c == '+') {
                                sign = 1;
                            } else if (c == '-') {
                                sign = -1;
                            } else if (c == '(') {
                                stack.push(result);
                                stack.push(sign);
                                result = 0;
                                sign = 1;
                            } else if (c == ')') {
                                result = result * stack.top(); stack.pop();
                                result += stack.top(); stack.pop();
                            }
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Trapping Rain Water",
                "https://leetcode.com/problems/trapping-rain-water/",
                solutionJava = """
                class Solution {
                    public int trap(int[] height) {
                        Stack<Integer> stack = new Stack<>();
                        int water = 0;
                        for (int i = 0; i < height.length; i++) {
                            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                                int top = stack.pop();
                                if (stack.isEmpty()) break;
                                int distance = i - stack.peek() - 1;
                                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                                water += distance * boundedHeight;
                            }
                            stack.push(i);
                        }
                        return water;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    int trap(vector<int>& height) {
                        stack<int> stack;
                        int water = 0;
                        for (int i = 0; i < height.size(); i++) {
                            while (!stack.empty() && height[i] > height[stack.top()]) {
                                int top = stack.top();
                                stack.pop();
                                if (stack.empty()) break;
                                int distance = i - stack.top() - 1;
                                int boundedHeight = min(height[i], height[stack.top()]) - height[top];
                                water += distance * boundedHeight;
                            }
                            stack.push(i);
                        }
                        return water;
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Sliding Window Maximum",
                "https://leetcode.com/problems/sliding-window-maximum/",
                solutionJava = """
                class Solution {
                    public int[] maxSlidingWindow(int[] nums, int k) {
                        int n = nums.length;
                        int[] result = new int[n - k + 1];
                        Deque<Integer> deque = new ArrayDeque<>();
                        for (int i = 0; i < n; i++) {
                            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                                deque.pollFirst();
                            }
                            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                                deque.pollLast();
                            }
                            deque.offerLast(i);
                            if (i >= k - 1) {
                                result[i - k + 1] = nums[deque.peekFirst()];
                            }
                        }
                        return result;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Solution {
                public:
                    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
                        int n = nums.size();
                        vector<int> result;
                        deque<int> deque;
                        for (int i = 0; i < n; i++) {
                            if (!deque.empty() && deque.front() == i - k) {
                                deque.pop_front();
                            }
                            while (!deque.empty() && nums[deque.back()] < nums[i]) {
                                deque.pop_back();
                            }
                            deque.push_back(i);
                            if (i >= k - 1) {
                                result.push_back(nums[deque.front()]);
                            }
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                "Design Circular Queue",
                "https://leetcode.com/problems/design-circular-queue/",
                solutionJava = """
        class MyCircularQueue {
            private int[] queue;
            private int head, tail, size;

            public MyCircularQueue(int k) {
                queue = new int[k];
                head = -1;
                tail = -1;
                size = k;
            }

            public boolean enQueue(int value) {
                if (isFull()) return false;
                if (isEmpty()) head = 0;
                tail = (tail + 1) % size;
                queue[tail] = value;
                return true;
            }

            public boolean deQueue() {
                if (isEmpty()) return false;
                if (head == tail) {
                    head = -1;
                    tail = -1;
                } else {
                    head = (head + 1) % size;
                }
                return true;
            }

            public int Front() {
                return isEmpty() ? -1 : queue[head];
            }

            public int Rear() {
                return isEmpty() ? -1 : queue[tail];
            }

            public boolean isEmpty() {
                return head == -1;
            }

            public boolean isFull() {
                return (tail + 1) % size == head;
            }
        }
    """.trimIndent(),
                solutionCpp = """
        class MyCircularQueue {
        private:
            vector<int> queue;
            int head, tail, size, capacity;

        public:
            MyCircularQueue(int k) : queue(k), head(-1), tail(-1), size(0), capacity(k) {}

            bool enQueue(int value) {
                if (isFull()) return false;
                if (isEmpty()) head = 0;
                tail = (tail + 1) % capacity;
                queue[tail] = value;
                size++;
                return true;
            }

            bool deQueue() {
                if (isEmpty()) return false;
                if (head == tail) {
                    head = -1;
                    tail = -1;
                } else {
                    head = (head + 1) % capacity;
                }
                size--;
                return true;
            }

            int Front() {
                return isEmpty() ? -1 : queue[head];
            }

            int Rear() {
                return isEmpty() ? -1 : queue[tail];
            }

            bool isEmpty() {
                return size == 0;
            }

            bool isFull() {
                return size == capacity;
            }
        };
    """.trimIndent()
            )
        ) // done
    ), Topic(
        topicName = "Sliding Window and Two Pointers",
        topicDetails = "Problems solved using sliding window or two-pointer techniques",
        questions = listOf(
            Question(
                name = "Longest Substring Without Repeating Characters",
                link = "https://leetcode.com/problems/longest-substring-without-repeating-characters/",
                solutionJava = """
                class LongestSubstring {
                    public int lengthOfLongestSubstring(String s) {
                        Set<Character> set = new HashSet<>();
                        int left = 0, right = 0, maxLength = 0;

                        while (right < s.length()) {
                            if (!set.contains(s.charAt(right))) {
                                set.add(s.charAt(right++));
                                maxLength = Math.max(maxLength, right - left);
                            } else {
                                set.remove(s.charAt(left++));
                            }
                        }
                        return maxLength;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class LongestSubstring {
                public:
                    int lengthOfLongestSubstring(string s) {
                        unordered_set<char> set;
                        int left = 0, right = 0, maxLength = 0;

                        while (right < s.length()) {
                            if (set.find(s[right]) == set.end()) {
                                set.insert(s[right++]);
                                maxLength = max(maxLength, right - left);
                            } else {
                                set.erase(s[left++]);
                            }
                        }
                        return maxLength;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Minimum Size Subarray Sum",
                link = "https://leetcode.com/problems/minimum-size-subarray-sum/",
                solutionJava = """
                class MinimumSizeSubarraySum {
                    public int minSubArrayLen(int target, int[] nums) {
                        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;

                        for (int right = 0; right < nums.length; right++) {
                            sum += nums[right];
                            while (sum >= target) {
                                minLength = Math.min(minLength, right - left + 1);
                                sum -= nums[left++];
                            }
                        }
                        return minLength == Integer.MAX_VALUE ? 0 : minLength;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class MinimumSizeSubarraySum {
                public:
                    int minSubArrayLen(int target, vector<int>& nums) {
                        int left = 0, sum = 0, minLength = INT_MAX;

                        for (int right = 0; right < nums.size(); right++) {
                            sum += nums[right];
                            while (sum >= target) {
                                minLength = min(minLength, right - left + 1);
                                sum -= nums[left++];
                            }
                        }
                        return minLength == INT_MAX ? 0 : minLength;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Longest Repeating Character Replacement",
                link = "https://leetcode.com/problems/longest-repeating-character-replacement/",
                solutionJava = """
                class LongestRepeatingCharacterReplacement {
                    public int characterReplacement(String s, int k) {
                        int[] count = new int[26];
                        int left = 0, maxCount = 0, maxLength = 0;

                        for (int right = 0; right < s.length(); right++) {
                            maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);
                            while (right - left + 1 - maxCount > k) {
                                count[s.charAt(left) - 'A']--;
                                left++;
                            }
                            maxLength = Math.max(maxLength, right - left + 1);
                        }
                        return maxLength;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class LongestRepeatingCharacterReplacement {
                public:
                    int characterReplacement(string s, int k) {
                        vector<int> count(26, 0);
                        int left = 0, maxCount = 0, maxLength = 0;

                        for (int right = 0; right < s.size(); right++) {
                            maxCount = max(maxCount, ++count[s[right] - 'A']);
                            while (right - left + 1 - maxCount > k) {
                                count[s[left] - 'A']--;
                                left++;
                            }
                            maxLength = max(maxLength, right - left + 1);
                        }
                        return maxLength;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Permutation in String",
                link = "https://leetcode.com/problems/permutation-in-string/",
                solutionJava = """
                class PermutationInString {
                    public boolean checkInclusion(String s1, String s2) {
                        int[] count = new int[26];
                        for (char c : s1.toCharArray()) count[c - 'a']++;

                        int left = 0, right = 0, required = s1.length();
                        while (right < s2.length()) {
                            if (count[s2.charAt(right++) - 'a']-- > 0) required--;
                            if (required == 0) return true;

                            if (right - left == s1.length() && count[s2.charAt(left++) - 'a']++ >= 0) required++;
                        }
                        return false;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class PermutationInString {
                public:
                    bool checkInclusion(string s1, string s2) {
                        vector<int> count(26, 0);
                        for (char c : s1) count[c - 'a']++;

                        int left = 0, right = 0, required = s1.size();
                        while (right < s2.size()) {
                            if (count[s2[right++] - 'a']-- > 0) required--;
                            if (required == 0) return true;

                            if (right - left == s1.size() && count[s2[left++] - 'a']++ >= 0) required++;
                        }
                        return false;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Find All Anagrams in a String",
                link = "https://leetcode.com/problems/find-all-anagrams-in-a-string/",
                solutionJava = """
                class FindAllAnagramsInAString {
                    public List<Integer> findAnagrams(String s, String p) {
                        List<Integer> result = new ArrayList<>();
                        int[] count = new int[26];

                        for (char c : p.toCharArray()) count[c - 'a']++;

                        int left = 0, right = 0, required = p.length();
                        while (right < s.length()) {
                            if (count[s.charAt(right++) - 'a']-- > 0) required--;
                            if (required == 0) result.add(left);

                            if (right - left == p.length() && count[s.charAt(left++) - 'a']++ >= 0) required++;
                        }
                        return result;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class FindAllAnagramsInAString {
                public:
                    vector<int> findAnagrams(string s, string p) {
                        vector<int> result;
                        vector<int> count(26, 0);

                        for (char c : p) count[c - 'a']++;

                        int left = 0, right = 0, required = p.size();
                        while (right < s.size()) {
                            if (count[s[right++] - 'a']-- > 0) required--;
                            if (required == 0) result.push_back(left);

                            if (right - left == p.size() && count[s[left++] - 'a']++ >= 0) required++;
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Sliding Window Maximum",
                link = "https://leetcode.com/problems/sliding-window-maximum/",
                solutionJava = """
        import java.util.*;

        class SlidingWindowMaximum {
            public int[] maxSlidingWindow(int[] nums, int k) {
                if (nums.length == 0) return new int[0];
                int n = nums.length;
                int[] result = new int[n - k + 1];
                Deque<Integer> deque = new LinkedList<>();

                for (int i = 0; i < n; i++) {
                    // Remove elements out of this window
                    if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                        deque.poll();
                    }
                    // Remove smaller elements as they are not useful
                    while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                        deque.pollLast();
                    }
                    deque.offer(i);
                    // Record the maximum of the current window
                    if (i >= k - 1) {
                        result[i - k + 1] = nums[deque.peek()];
                    }
                }
                return result;
            }
        }
    """.trimIndent(),
                solutionCpp = """
        class SlidingWindowMaximum {
        public:
            vector<int> maxSlidingWindow(vector<int>& nums, int k) {
                if (nums.empty()) return {};
                vector<int> result(nums.size() - k + 1);
                deque<int> dq;

                for (int i = 0; i < nums.size(); i++) {
                    // Remove elements out of this window
                    if (!dq.empty() && dq.front() < i - k + 1) {
                        dq.pop_front();
                    }
                    // Remove smaller elements as they are not useful
                    while (!dq.empty() && nums[dq.back()] < nums[i]) {
                        dq.pop_back();
                    }
                    dq.push_back(i);
                    // Record the maximum of the current window
                    if (i >= k - 1) {
                        result[i - k + 1] = nums[dq.front()];
                    }
                }
                return result;
            }
        };
    """.trimIndent()
            ),
            Question(
                name = "Container With Most Water",
                link = "https://leetcode.com/problems/container-with-most-water/",
                solutionJava = """
                class ContainerWithMostWater {
                    public int maxArea(int[] height) {
                        int left = 0, right = height.length - 1, maxArea = 0;
                        while (left < right) {
                            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
                            if (height[left] < height[right]) left++;
                            else right--;
                        }
                        return maxArea;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class ContainerWithMostWater {
                public:
                    int maxArea(vector<int>& height) {
                        int left = 0, right = height.size() - 1, maxArea = 0;
                        while (left < right) {
                            maxArea = max(maxArea, min(height[left], height[right]) * (right - left));
                            if (height[left] < height[right]) left++;
                            else right--;
                        }
                        return maxArea;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "3Sum",
                link = "https://leetcode.com/problems/3sum/",
                solutionJava = """
                class ThreeSum {
                    public List<List<Integer>> threeSum(int[] nums) {
                        List<List<Integer>> result = new ArrayList<>();
                        Arrays.sort(nums);

                        for (int i = 0; i < nums.length - 2; i++) {
                            if (i > 0 && nums[i] == nums[i - 1]) continue;
                            int left = i + 1, right = nums.length - 1;
                            while (left < right) {
                                int sum = nums[i] + nums[left] + nums[right];
                                if (sum == 0) {
                                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                                    while (left < right && nums[left] == nums[left + 1]) left++;
                                    while (left < right && nums[right] == nums[right - 1]) right--;
                                    left++;
                                    right--;
                                } else if (sum < 0) {
                                    left++;
                                } else {
                                    right--;
                                }
                            }
                        }
                        return result;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class ThreeSum {
                public:
                    vector<vector<int>> threeSum(vector<int>& nums) {
                        vector<vector<int>> result;
                        sort(nums.begin(), nums.end());

                        for (int i = 0; i < nums.size() - 2; i++) {
                            if (i > 0 && nums[i] == nums[i - 1]) continue;
                            int left = i + 1, right = nums.size() - 1;
                            while (left < right) {
                                int sum = nums[i] + nums[left] + nums[right];
                                if (sum == 0) {
                                    result.push_back({nums[i], nums[left], nums[right]});
                                    while (left < right && nums[left] == nums[left + 1]) left++;
                                    while (left < right && nums[right] == nums[right - 1]) right--;
                                    left++;
                                    right--;
                                } else if (sum < 0) {
                                    left++;
                                } else {
                                    right--;
                                }
                            }
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Remove Duplicates from Sorted Array",
                link = "https://leetcode.com/problems/remove-duplicates-from-sorted-array/",
                solutionJava = """
                class RemoveDuplicatesFromSortedArray {
                    public int removeDuplicates(int[] nums) {
                        int length = 1;
                        for (int i = 1; i < nums.length; i++) {
                            if (nums[i] != nums[i - 1]) {
                                nums[length++] = nums[i];
                            }
                        }
                        return length;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class RemoveDuplicatesFromSortedArray {
                public:
                    int removeDuplicates(vector<int>& nums) {
                        int length = 1;
                        for (int i = 1; i < nums.size(); i++) {
                            if (nums[i] != nums[i - 1]) {
                                nums[length++] = nums[i];
                            }
                        }
                        return length;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Trapping Rain Water",
                link = "https://leetcode.com/problems/trapping-rain-water/",
                solutionJava = """
                class TrappingRainWater {
                    public int trap(int[] height) {
                        int left = 0, right = height.length - 1;
                        int leftMax = 0, rightMax = 0, totalWater = 0;

                        while (left < right) {
                            if (height[left] < height[right]) {
                                if (height[left] >= leftMax) leftMax = height[left];
                                else totalWater += leftMax - height[left];
                                left++;
                            } else {
                                if (height[right] >= rightMax) rightMax = height[right];
                                else totalWater += rightMax - height[right];
                                right--;
                            }
                        }
                        return totalWater;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class TrappingRainWater {
                public:
                    int trap(vector<int>& height) {
                        int left = 0, right = height.size() - 1;
                        int leftMax = 0, rightMax = 0, totalWater = 0;

                        while (left < right) {
                            if (height[left] < height[right]) {
                                if (height[left] >= leftMax) leftMax = height[left];
                                else totalWater += leftMax - height[left];
                                left++;
                            } else {
                                if (height[right] >= rightMax) rightMax = height[right];
                                else totalWater += rightMax - height[right];
                                right--;
                            }
                        }
                        return totalWater;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Sort Colors",
                link = "https://leetcode.com/problems/sort-colors/",
                solutionJava = """
                class SortColors {
                    public void sortColors(int[] nums) {
                        int low = 0, mid = 0, high = nums.length - 1;
                        while (mid <= high) {
                            if (nums[mid] == 0) {
                                swap(nums, low++, mid++);
                            } else if (nums[mid] == 1) {
                                mid++;
                            } else {
                                swap(nums, mid, high--);
                            }
                        }
                    }

                    private void swap(int[] nums, int i, int j) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class SortColors {
                public:
                    void sortColors(vector<int>& nums) {
                        int low = 0, mid = 0, high = nums.size() - 1;
                        while (mid <= high) {
                            if (nums[mid] == 0) {
                                swap(nums[low++], nums[mid++]);
                            } else if (nums[mid] == 1) {
                                mid++;
                            } else {
                                swap(nums[mid], nums[high--]);
                            }
                        }
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Longest Mountain in Array",
                link = "https://leetcode.com/problems/longest-mountain-in-array/",
                solutionJava = """
                class LongestMountainInArray {
                    public int longestMountain(int[] A) {
                        int n = A.length;
                        if (n < 3) return 0;

                        int longest = 0;
                        for (int i = 1; i < n - 1; ) {
                            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                                int left = i - 1, right = i + 1;
                                while (left > 0 && A[left - 1] < A[left]) left--;
                                while (right < n - 1 && A[right] > A[right + 1]) right++;
                                longest = Math.max(longest, right - left + 1);
                                i = right + 1;
                            } else {
                                i++;
                            }
                        }
                        return longest;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class LongestMountainInArray {
                public:
                    int longestMountain(vector<int>& A) {
                        int n = A.size();
                        if (n < 3) return 0;

                        int longest = 0;
                        for (int i = 1; i < n - 1; ) {
                            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                                int left = i - 1, right = i + 1;
                                while (left > 0 && A[left - 1] < A[left]) left--;
                                while (right < n - 1 && A[right] > A[right + 1]) right++;
                                longest = max(longest, right - left + 1);
                                i = right + 1;
                            } else {
                                i++;
                            }
                        }
                        return longest;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Minimum Window Substring",
                link = "https://leetcode.com/problems/minimum-window-substring/",
                solutionJava = """
                class MinimumWindowSubstring {
                    public String minWindow(String s, String t) {
                        if (t.length() > s.length()) return "";
                        Map<Character, Integer> dictT = new HashMap<>();
                        for (char c : t.toCharArray()) dictT.put(c, dictT.getOrDefault(c, 0) + 1);
                        
                        int required = dictT.size();
                        int l = 0, r = 0, formed = 0;
                        Map<Character, Integer> windowCounts = new HashMap<>();
                        int[] ans = {-1, 0, 0};

                        while (r < s.length()) {
                            char c = s.charAt(r);
                            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
                            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                                formed++;
                            }
                            while (l <= r && formed == required) {
                                c = s.charAt(l);
                                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                                    ans[0] = r - l + 1;
                                    ans[1] = l;
                                    ans[2] = r;
                                }
                                windowCounts.put(c, windowCounts.get(c) - 1);
                                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                                    formed--;
                                }
                                l++;
                            }
                            r++;
                        }
                        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class MinimumWindowSubstring {
                public:
                    string minWindow(string s, string t) {
                        if (t.length() > s.length()) return "";
                        unordered_map<char, int> dictT;
                        for (char c : t) dictT[c]++;

                        int required = dictT.size();
                        int l = 0, r = 0, formed = 0;
                        unordered_map<char, int> windowCounts;
                        vector<int> ans = {-1, 0, 0};

                        while (r < s.length()) {
                            char c = s[r];
                            windowCounts[c]++;
                            if (dictT.count(c) && windowCounts[c] == dictT[c]) {
                                formed++;
                            }
                            while (l <= r && formed == required) {
                                c = s[l];
                                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                                    ans[0] = r - l + 1;
                                    ans[1] = l;
                                    ans[2] = r;
                                }
                                windowCounts[c]--;
                                if (dictT.count(c) && windowCounts[c] < dictT[c]) {
                                    formed--;
                                }
                                l++;
                            }
                            r++;
                        }
                        return ans[0] == -1 ? "" : s.substr(ans[1], ans[0]);
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Subarrays with K Different Integers",
                link = "https://leetcode.com/problems/subarrays-with-k-different-integers/",
                solutionJava = """
                class SubarraysWithKDifferentIntegers {
                    public int subarraysWithKDistinct(int[] A, int K) {
                        return atMostK(A, K) - atMostK(A, K - 1);
                    }

                    private int atMostK(int[] A, int K) {
                        int left = 0, right = 0, count = 0;
                        int[] countMap = new int[A.length + 1];
                        while (right < A.length) {
                            if (countMap[A[right]]++ == 0) count++;
                            while (count > K) {
                                if (--countMap[A[left]] == 0) count--;
                                left++;
                            }
                            right++;
                        }
                        return right - left;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class SubarraysWithKDifferentIntegers {
                public:
                    int subarraysWithKDistinct(vector<int>& A, int K) {
                        return atMostK(A, K) - atMostK(A, K - 1);
                    }

                    private:
                    int atMostK(vector<int>& A, int K) {
                        int left = 0, right = 0, count = 0;
                        vector<int> countMap(A.size() + 1, 0);
                        while (right < A.size()) {
                            if (countMap[A[right]]++ == 0) count++;
                            while (count > K) {
                                if (--countMap[A[left]] == 0) count--;
                                left++;
                            }
                            right++;
                        }
                        return right - left;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Max Consecutive Ones III",
                link = "https://leetcode.com/problems/max-consecutive-ones-iii/",
                solutionJava = """
                class MaxConsecutiveOnesIII {
                    public int longestOnes(int[] A, int K) {
                        int left = 0, right = 0;
                        while (right < A.length) {
                            if (A[right] == 0) K--;
                            if (K < 0) {
                                if (A[left] == 0) K++;
                                left++;
                            }
                            right++;
                        }
                        return right - left;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class MaxConsecutiveOnesIII {
                public:
                    int longestOnes(vector<int>& A, int K) {
                        int left = 0, right = 0;
                        while (right < A.size()) {
                            if (A[right] == 0) K--;
                            if (K < 0) {
                                if (A[left] == 0) K++;
                                left++;
                            }
                            right++;
                        }
                        return right - left;
                    }
                };
            """.trimIndent()
            )
        )   // done
    ), Topic(
        topicName = "Heaps",
        topicDetails = "Problems involving heap data structure",
        questions = listOf(
            Question(
                name = "Kth Largest Element in an Array",
                link = "https://leetcode.com/problems/kth-largest-element-in-an-array/",
                solutionJava = """
                class Question_KthLargestElement {
                    public int findKthLargest(int[] nums, int k) {
                        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                        for (int num : nums) {
                            minHeap.offer(num);
                            if (minHeap.size() > k) {
                                minHeap.poll();
                            }
                        }
                        return minHeap.peek();
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_KthLargestElement {
                public:
                    int findKthLargest(vector<int>& nums, int k) {
                        priority_queue<int, vector<int>, greater<int>> minHeap;
                        for (int num : nums) {
                            minHeap.push(num);
                            if (minHeap.size() > k) {
                                minHeap.pop();
                            }
                        }
                        return minHeap.top();
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Top K Frequent Elements",
                link = "https://leetcode.com/problems/top-k-frequent-elements/",
                solutionJava = """
                class Question_TopKFrequentElements {
                    public List<Integer> topKFrequent(int[] nums, int k) {
                        Map<Integer, Integer> count = new HashMap<>();
                        for (int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);
                        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
                        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                            heap.offer(entry);
                            if (heap.size() > k) heap.poll();
                        }
                        List<Integer> result = new ArrayList<>();
                        while (!heap.isEmpty()) result.add(heap.poll().getKey());
                        return result;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_TopKFrequentElements {
                public:
                    vector<int> topKFrequent(vector<int>& nums, int k) {
                        unordered_map<int, int> count;
                        for (int num : nums) count[num]++;
                        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> heap;
                        for (auto& entry : count) {
                            heap.push({entry.second, entry.first});
                            if (heap.size() > k) heap.pop();
                        }
                        vector<int> result;
                        while (!heap.empty()) {
                            result.push_back(heap.top().second);
                            heap.pop();
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Find Median from Data Stream",
                link = "https://leetcode.com/problems/find-median-from-data-stream/",
                solutionJava = """
                class Question_FindMedian {
                    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
                    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

                    public void addNum(int num) {
                        maxHeap.offer(num);
                        minHeap.offer(maxHeap.poll());
                        if (maxHeap.size() < minHeap.size()) {
                            maxHeap.offer(minHeap.poll());
                        }
                    }

                    public double findMedian() {
                        if (maxHeap.size() > minHeap.size()) {
                            return maxHeap.peek();
                        }
                        return (maxHeap.peek() + minHeap.peek()) / 2.0;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_FindMedian {
                private:
                    priority_queue<int> maxHeap; // max heap for the lower half
                    priority_queue<int, vector<int>, greater<int>> minHeap; // min heap for the upper half

                public:
                    void addNum(int num) {
                        maxHeap.push(num);
                        minHeap.push(maxHeap.top());
                        maxHeap.pop();
                        if (maxHeap.size() < minHeap.size()) {
                            maxHeap.push(minHeap.top());
                            minHeap.pop();
                        }
                    }

                    double findMedian() {
                        if (maxHeap.size() > minHeap.size()) {
                            return maxHeap.top();
                        }
                        return (maxHeap.top() + minHeap.top()) / 2.0;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Merge K Sorted Lists",
                link = "https://leetcode.com/problems/merge-k-sorted-lists/",
                solutionJava = """
                class Question_MergeKSortedLists {
                    public ListNode mergeKLists(List<ListNode> lists) {
                        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
                        for (ListNode node : lists) {
                            if (node != null) {
                                minHeap.offer(node);
                            }
                        }
                        ListNode dummy = new ListNode(0);
                        ListNode current = dummy;
                        while (!minHeap.isEmpty()) {
                            current.next = minHeap.poll();
                            current = current.next;
                            if (current.next != null) {
                                minHeap.offer(current.next);
                            }
                        }
                        return dummy.next;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_MergeKSortedLists {
                public:
                    ListNode* mergeKLists(vector<ListNode*>& lists) {
                        auto cmp = [](ListNode* a, ListNode* b) { return a->val > b->val; };
                        priority_queue<ListNode*, vector<ListNode*>, decltype(cmp)> minHeap(cmp);
                        for (ListNode* node : lists) {
                            if (node != nullptr) {
                                minHeap.push(node);
                            }
                        }
                        ListNode* dummy = new ListNode(0);
                        ListNode* current = dummy;
                        while (!minHeap.empty()) {
                            current->next = minHeap.top();
                            minHeap.pop();
                            current = current->next;
                            if (current->next != nullptr) {
                                minHeap.push(current->next);
                            }
                        }
                        return dummy->next;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Sliding Window Median",
                link = "https://leetcode.com/problems/sliding-window-median/",
                solutionJava = """
                class Question_SlidingWindowMedian {
                    public double[] medianSlidingWindow(int[] nums, int k) {
                        double[] result = new double[nums.length - k + 1];
                        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
                        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                        for (int i = 0; i < nums.length; i++) {
                            maxHeap.offer(nums[i]);
                            minHeap.offer(maxHeap.poll());
                            if (maxHeap.size() < minHeap.size()) {
                                maxHeap.offer(minHeap.poll());
                            }
                            if (i >= k - 1) {
                                result[i - k + 1] = maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;
                                int toRemove = nums[i - k + 1];
                                if (toRemove <= maxHeap.peek()) {
                                    maxHeap.remove(toRemove);
                                } else {
                                    minHeap.remove(toRemove);
                                }
                                rebalanceHeaps(maxHeap, minHeap);
                            }
                        }
                        return result;
                    }

                    private void rebalanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
                        while (maxHeap.size() < minHeap.size()) {
                            maxHeap.offer(minHeap.poll());
                        }
                        while (maxHeap.size() > minHeap.size() + 1) {
                            minHeap.offer(maxHeap.poll());
                        }
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_SlidingWindowMedian {
                public:
                    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
                        vector<double> result(nums.size() - k + 1);
                        priority_queue<int> maxHeap; // max heap for the left half
                        priority_queue<int, vector<int>, greater<int>> minHeap; // min heap for the right half
                        for (int i = 0; i < nums.size(); i++) {
                            maxHeap.push(nums[i]);
                            minHeap.push(maxHeap.top());
                            maxHeap.pop();
                            if (maxHeap.size() < minHeap.size()) {
                                maxHeap.push(minHeap.top());
                                minHeap.pop();
                            }
                            if (i >= k - 1) {
                                result[i - k + 1] = (maxHeap.size() > minHeap.size()) ? maxHeap.top() : (maxHeap.top() + minHeap.top()) / 2.0;
                                int toRemove = nums[i - k + 1];
                                if (toRemove <= maxHeap.top()) {
                                    maxHeap.remove(toRemove);
                                } else {
                                    minHeap.remove(toRemove);
                                }
                                rebalanceHeaps(maxHeap, minHeap);
                            }
                        }
                        return result;
                    }

                    void rebalanceHeaps(priority_queue<int>& maxHeap, priority_queue<int, vector<int>, greater<int>>& minHeap) {
                        while (maxHeap.size() < minHeap.size()) {
                            maxHeap.push(minHeap.top());
                            minHeap.pop();
                        }
                        while (maxHeap.size() > minHeap.size() + 1) {
                            minHeap.push(maxHeap.top());
                            maxHeap.pop();
                        }
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "K Closest Points to Origin",
                link = "https://leetcode.com/problems/k-closest-points-to-origin/",
                solutionJava = """
                class Question_KClosestPoints {
                    public int[][] kClosest(int[][] points, int k) {
                        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));
                        for (int[] point : points) {
                            maxHeap.offer(point);
                            if (maxHeap.size() > k) {
                                maxHeap.poll();
                            }
                        }
                        return maxHeap.toArray(new int[k][2]);
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_KClosestPoints {
                public:
                    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
                        auto cmp = [](vector<int>& a, vector<int>& b) {
                            return (a[0] * a[0] + a[1] * a[1]) > (b[0] * b[0] + b[1] * b[1]);
                        };
                        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> maxHeap(cmp);
                        for (auto& point : points) {
                            maxHeap.push(point);
                            if (maxHeap.size() > k) {
                                maxHeap.pop();
                            }
                        }
                        vector<vector<int>> result(k);
                        for (int i = 0; i < k; i++) {
                            result[i] = maxHeap.top();
                            maxHeap.pop();
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Ugly Number II",
                link = "https://leetcode.com/problems/ugly-number-ii/",
                solutionJava = """
                class Question_UglyNumberII {
                    public int nthUglyNumber(int n) {
                        int[] uglyNumbers = new int[n];
                        uglyNumbers[0] = 1;
                        int i2 = 0, i3 = 0, i5 = 0;
                        int next2 = 2, next3 = 3, next5 = 5;

                        for (int i = 1; i < n; i++) {
                            int nextUgly = Math.min(next2, Math.min(next3, next5));
                            uglyNumbers[i] = nextUgly;

                            if (nextUgly == next2) {
                                i2++;
                                next2 = uglyNumbers[i2] * 2;
                            }
                            if (nextUgly == next3) {
                                i3++;
                                next3 = uglyNumbers[i3] * 3;
                            }
                            if (nextUgly == next5) {
                                i5++;
                                next5 = uglyNumbers[i5] * 5;
                            }
                        }
                        return uglyNumbers[n - 1];
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_UglyNumberII {
                public:
                    int nthUglyNumber(int n) {
                        vector<int> uglyNumbers(n);
                        uglyNumbers[0] = 1;
                        int i2 = 0, i3 = 0, i5 = 0;
                        int next2 = 2, next3 = 3, next5 = 5;

                        for (int i = 1; i < n; i++) {
                            int nextUgly = min(next2, min(next3, next5));
                            uglyNumbers[i] = nextUgly;
                            if (nextUgly == next2) {
                                i2++;
                                next2 = uglyNumbers[i2] * 2;
                            }
                            if (nextUgly == next3) {
                                i3++;
                                next3 = uglyNumbers[i3] * 3;
                            }
                            if (nextUgly == next5) {
                                i5++;
                                next5 = uglyNumbers[i5] * 5;
                            }
                        }
                        return uglyNumbers[n - 1];
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Furthest Building You Can Reach",
                link = "https://leetcode.com/problems/furthest-building-you-can-reach/",
                solutionJava = """
                class Question_FurthestBuilding {
                    public int furthestBuilding(int[] heights, int bricks, int ladders) {
                        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                        for (int i = 0; i < heights.length - 1; i++) {
                            int diff = heights[i + 1] - heights[i];
                            if (diff > 0) {
                                minHeap.offer(diff);
                                if (minHeap.size() > ladders) {
                                    bricks -= minHeap.poll();
                                }
                                if (bricks < 0) {
                                    return i;
                                }
                            }
                        }
                        return heights.length - 1;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_FurthestBuilding {
                public:
                    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
                        priority_queue<int> minHeap;
                        for (int i = 0; i < heights.size() - 1; i++) {
                            int diff = heights[i + 1] - heights[i];
                            if (diff > 0) {
                                minHeap.push(diff);
                                if (minHeap.size() > ladders) {
                                    bricks -= minHeap.top();
                                    minHeap.pop();
                                }
                                if (bricks < 0) {
                                    return i;
                                }
                            }
                        }
                        return heights.size() - 1;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Kth Smallest Element in a Sorted Matrix",
                link = "https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/",
                solutionJava = """
                class Question_KthSmallestElementInSortedMatrix {
                    public int kthSmallest(int[][] matrix, int k) {
                        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
                        for (int i = 0; i < matrix.length; i++) {
                            minHeap.offer(new int[]{matrix[i][0], i, 0});
                        }
                        int count = 0;
                        while (count < k - 1) {
                            int[] current = minHeap.poll();
                            int row = current[1], col = current[2];
                            if (col + 1 < matrix[0].length) {
                                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
                            }
                            count++;
                        }
                        return minHeap.poll()[0];
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_KthSmallestElementInSortedMatrix {
                public:
                    int kthSmallest(vector<vector<int>>& matrix, int k) {
                        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> minHeap;
                        for (int i = 0; i < matrix.size(); i++) {
                            minHeap.push({matrix[i][0], i, 0});
                        }
                        int count = 0;
                        while (count < k - 1) {
                            vector<int> current = minHeap.top();
                            minHeap.pop();
                            int row = current[1], col = current[2];
                            if (col + 1 < matrix[0].size()) {
                                minHeap.push({matrix[row][col + 1], row, col + 1});
                            }
                            count++;
                        }
                        return minHeap.top()[0];
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Reorganize String",
                link = "https://leetcode.com/problems/reorganize-string/",
                solutionJava = """
                class Question_ReorganizeString {
                    public String reorganizeString(String s) {
                        int[] count = new int[26];
                        for (char c : s.toCharArray()) {
                            count[c - 'a']++;
                        }
                        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
                        for (int i = 0; i < 26; i++) {
                            if (count[i] > 0) {
                                maxHeap.offer(new int[]{i, count[i]});
                            }
                        }
                        StringBuilder result = new StringBuilder();
                        while (maxHeap.size() > 1) {
                            int[] first = maxHeap.poll();
                            int[] second = maxHeap.poll();
                            result.append((char) (first[0] + 'a'));
                            result.append((char) (second[0] + 'a'));
                            if (--first[1] > 0) {
                                maxHeap.offer(first);
                            }
                            if (--second[1] > 0) {
                                maxHeap.offer(second);
                            }
                        }
                        if (!maxHeap.isEmpty()) {
                            int[] last = maxHeap.poll();
                            if (last[1] > 1) return "";
                            result.append((char) (last[0] + 'a'));
                        }
                        return result.toString();
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_ReorganizeString {
                public:
                    string reorganizeString(string s) {
                        vector<int> count(26, 0);
                        for (char c : s) {
                            count[c - 'a']++;
                        }
                        priority_queue<pair<int, char>> maxHeap;
                        for (int i = 0; i < 26; i++) {
                            if (count[i] > 0) {
                                maxHeap.push({count[i], 'a' + i});
                            }
                        }
                        string result;
                        while (maxHeap.size() > 1) {
                            auto first = maxHeap.top(); maxHeap.pop();
                            auto second = maxHeap.top(); maxHeap.pop();
                            result += first.second;
                            result += second.second;
                            if (--first.first > 0) maxHeap.push(first);
                            if (--second.first > 0) maxHeap.push(second);
                        }
                        if (!maxHeap.empty()) {
                            if (maxHeap.top().first > 1) return "";
                            result += maxHeap.top().second;
                        }
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Smallest Range Covering Elements from K Lists",
                link = "https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/",
                solutionJava = """
                class Question_SmallestRange {
                    public int[] smallestRange(List<List<Integer>> nums) {
                        int minRange = Integer.MAX_VALUE;
                        int start = 0, end = 0;
                        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
                        int max = Integer.MIN_VALUE;

                        for (int i = 0; i < nums.size(); i++) {
                            minHeap.offer(new int[]{nums.get(i).get(0), i, 0});
                            max = Math.max(max, nums.get(i).get(0));
                        }

                        while (minHeap.size() == nums.size()) {
                            int[] current = minHeap.poll();
                            int min = current[0], row = current[1], col = current[2];

                            if (max - min < minRange) {
                                minRange = max - min;
                                start = min;
                                end = max;
                            }
                            if (col + 1 < nums.get(row).size()) {
                                minHeap.offer(new int[]{nums.get(row).get(col + 1), row, col + 1});
                                max = Math.max(max, nums.get(row).get(col + 1));
                            }
                        }
                        return new int[]{start, end};
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_SmallestRange {
                public:
                    vector<int> smallestRange(vector<vector<int>>& nums) {
                        int minRange = INT_MAX;
                        int start = 0, end = 0;
                        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> minHeap;
                        int max = INT_MIN;

                        for (int i = 0; i < nums.size(); i++) {
                            minHeap.push({nums[i][0], i, 0});
                            max = max(max, nums[i][0]);
                        }

                        while (minHeap.size() == nums.size()) {
                            vector<int> current = minHeap.top(); minHeap.pop();
                            int min = current[0], row = current[1], col = current[2];

                            if (max - min < minRange) {
                                minRange = max - min;
                                start = min;
                                end = max;
                            }
                            if (col + 1 < nums[row].size()) {
                                minHeap.push({nums[row][col + 1], row, col + 1});
                                max = max(max, nums[row][col + 1]);
                            }
                        }
                        return {start, end};
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "IPO",
                link = "https://leetcode.com/problems/ipo/",
                solutionJava = """
                class Question_IPO {
                    public int[] findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
                        int n = Profits.length;
                        int[][] projects = new int[n][2];
                        for (int i = 0; i < n; i++) {
                            projects[i][0] = Capital[i];
                            projects[i][1] = Profits[i];
                        }
                        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

                        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
                        int j = 0;
                        for (int i = 0; i < k; i++) {
                            while (j < n && projects[j][0] <= W) {
                                maxHeap.offer(projects[j][1]);
                                j++;
                            }
                            if (maxHeap.isEmpty()) break;
                            W += maxHeap.poll();
                        }
                        return new int[]{W};
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_IPO {
                public:
                    vector<int> findMaximizedCapital(int k, int W, vector<int>& Profits, vector<int>& Capital) {
                        int n = Profits.size();
                        vector<pair<int, int>> projects(n);
                        for (int i = 0; i < n; i++) {
                            projects[i] = {Capital[i], Profits[i]};
                        }
                        sort(projects.begin(), projects.end());

                        priority_queue<int> maxHeap;
                        int j = 0;
                        for (int i = 0; i < k; i++) {
                            while (j < n && projects[j].first <= W) {
                                maxHeap.push(projects[j].second);
                                j++;
                            }
                            if (maxHeap.empty()) break;
                            W += maxHeap.top();
                            maxHeap.pop();
                        }
                        return {W};
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Find K Pairs with Smallest Sums",
                link = "https://leetcode.com/problems/find-k-pairs-with-smallest-sums/",
                solutionJava = """
                class Question_FindKPairs {
                    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
                        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0] + b[1], a[0] + a[1]));
                        for (int i = 0; i < Math.min(nums1.length, k); i++) {
                            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                                maxHeap.offer(new int[]{nums1[i], nums2[j]});
                                if (maxHeap.size() > k) {
                                    maxHeap.poll();
                                }
                            }
                        }
                        List<int[]> result = new ArrayList<>();
                        while (!maxHeap.isEmpty()) {
                            result.add(maxHeap.poll());
                        }
                        Collections.reverse(result);
                        return result;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_FindKPairs {
                public:
                    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
                        priority_queue<pair<int, pair<int, int>>> maxHeap;
                        for (int i = 0; i < min(nums1.size(), k); i++) {
                            for (int j = 0; j < min(nums2.size(), k); j++) {
                                maxHeap.push({-(nums1[i] + nums2[j]), {nums1[i], nums2[j]}});
                                if (maxHeap.size() > k) {
                                    maxHeap.pop();
                                }
                            }
                        }
                        vector<vector<int>> result;
                        while (!maxHeap.empty()) {
                            auto top = maxHeap.top(); maxHeap.pop();
                            result.push_back({top.second.first, top.second.second});
                        }
                        reverse(result.begin(), result.end());
                        return result;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Trapping Rain Water II",
                link = "https://leetcode.com/problems/trapping-rain-water-ii/",
                solutionJava = """
                class Question_TrappingRainWaterII {
                    public int trapRainWater(int[][] heightMap) {
                        if (heightMap.length == 0 || heightMap[0].length == 0) return 0;
                        int m = heightMap.length, n = heightMap[0].length;
                        boolean[][] visited = new boolean[m][n];
                        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
                        for (int i = 0; i < m; i++) {
                            minHeap.offer(new int[]{i, 0, heightMap[i][0]});
                            minHeap.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
                            visited[i][0] = visited[i][n - 1] = true;
                        }
                        for (int j = 0; j < n; j++) {
                            minHeap.offer(new int[]{0, j, heightMap[0][j]});
                            minHeap.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
                            visited[0][j] = visited[m - 1][j] = true;
                        }

                        int waterTrapped = 0;
                        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                        while (!minHeap.isEmpty()) {
                            int[] current = minHeap.poll();
                            int x = current[0], y = current[1], height = current[2];

                            for (int[] dir : directions) {
                                int newX = x + dir[0], newY = y + dir[1];
                                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                                    waterTrapped += Math.max(0, height - heightMap[newX][newY]);
                                    minHeap.offer(new int[]{newX, newY, Math.max(height, heightMap[newX][newY])});
                                    visited[newX][newY] = true;
                                }
                            }
                        }
                        return waterTrapped;
                    }
                }
            """.trimIndent(),
                solutionCpp = """
                class Question_TrappingRainWaterII {
                public:
                    int trapRainWater(vector<vector<int>>& heightMap) {
                        if (heightMap.empty() || heightMap[0].empty()) return 0;
                        int m = heightMap.size(), n = heightMap[0].size();
                        vector<vector<bool>> visited(m, vector<bool>(n, false));
                        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> minHeap;
                        for (int i = 0; i < m; i++) {
                            minHeap.push({heightMap[i][0], i, 0});
                            minHeap.push({heightMap[i][n - 1], i, n - 1});
                            visited[i][0] = visited[i][n - 1] = true;
                        }
                        for (int j = 0; j < n; j++) {
                            minHeap.push({heightMap[0][j], 0, j});
                            minHeap.push({heightMap[m - 1][j], m - 1, j});
                            visited[0][j] = visited[m - 1][j] = true;
                        }

                        int waterTrapped = 0;
                        vector<vector<int>> directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                        while (!minHeap.empty()) {
                            auto current = minHeap.top(); minHeap.pop();
                            int height = current[0], x = current[1], y = current[2];

                            for (auto dir : directions) {
                                int newX = x + dir[0], newY = y + dir[1];
                                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                                    waterTrapped += max(0, height - heightMap[newX][newY]);
                                    minHeap.push({max(height, heightMap[newX][newY]), newX, newY});
                                    visited[newX][newY] = true;
                                }
                            }
                        }
                        return waterTrapped;
                    }
                };
            """.trimIndent()
            ),
            Question(
                name = "Minimum Cost to Hire K Workers",
                link = "https://leetcode.com/problems/minimum-cost-to-hire-k-workers/",
                solutionJava = """
        class Question_MinimumCostToHire {
            public double minCostToHireWorkers(int[] quality, int[] wage, int K) {
                int n = quality.length;
                double[][] workers = new double[n][3];
                for (int i = 0; i < n; i++) {
                    workers[i][0] = (double) wage[i] / quality[i];
                    workers[i][1] = (double) wage[i];
                    workers[i][2] = quality[i];
                }
                Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));

                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
                double totalQuality = 0;
                double minCost = Double.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    maxHeap.offer((int) workers[i][2]);
                    totalQuality += workers[i][2];

                    if (maxHeap.size() > K) {
                        totalQuality -= maxHeap.poll();
                    }
                    if (maxHeap.size() == K) {
                        minCost = Math.min(minCost, totalQuality * workers[i][0]);
                    }
                }
                return minCost;
            }
        }
    """.trimIndent(),
                solutionCpp = """
        class Question_MinimumCostToHire {
        public:
            double minCostToHireWorkers(vector<int>& quality, vector<int>& wage, int K) {
                int n = quality.size();
                vector<pair<double, pair<int, int>>> workers(n);
                for (int i = 0; i < n; i++) {
                    workers[i] = { (double) wage[i] / quality[i], { wage[i], quality[i] } };
                }
                sort(workers.begin(), workers.end());

                priority_queue<int> maxHeap;
                double totalQuality = 0;
                double minCost = DBL_MAX;

                for (int i = 0; i < n; i++) {
                    maxHeap.push(workers[i].second.second);
                    totalQuality += workers[i].second.second;

                    if (maxHeap.size() > K) {
                        totalQuality -= maxHeap.top();
                        maxHeap.pop();
                    }
                    if (maxHeap.size() == K) {
                        minCost = min(minCost, totalQuality * workers[i].first);
                    }
                }
                return minCost;
            }
        };
    """.trimIndent()
            )

        )   // done
    ), Topic(
        topicName = "Greedy Algorithms",
        topicDetails = "Problems solved using greedy approach",
        questions = listOf(
            Question(
                name = "Jump Game",
                link = "https://leetcode.com/problems/jump-game/",
                solutionJava = """
                public boolean canJump(int[] nums) {
                    int maxReach = 0;
                    for (int i = 0; i < nums.length; i++) {
                        if (i > maxReach) return false;
                        maxReach = Math.max(maxReach, i + nums[i]);
                    }
                    return true;
                }
            """.trimIndent(),
                solutionCpp = """
                bool canJump(vector<int>& nums) {
                    int maxReach = 0;
                    for (int i = 0; i < nums.size(); i++) {
                        if (i > maxReach) return false;
                        maxReach = max(maxReach, i + nums[i]);
                    }
                    return true;
                }
            """.trimIndent()
            ),
            Question(
                name = "Best Time to Buy and Sell Stock II",
                link = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/",
                solutionJava = """
                public int maxProfit(int[] prices) {
                    int profit = 0;
                    for (int i = 1; i < prices.length; i++) {
                        if (prices[i] > prices[i - 1]) {
                            profit += prices[i] - prices[i - 1];
                        }
                    }
                    return profit;
                }
            """.trimIndent(),
                solutionCpp = """
                int maxProfit(vector<int>& prices) {
                    int profit = 0;
                    for (int i = 1; i < prices.size(); i++) {
                        if (prices[i] > prices[i - 1]) {
                            profit += prices[i] - prices[i - 1];
                        }
                    }
                    return profit;
                }
            """.trimIndent()
            ),
            Question(
                name = "Gas Station",
                link = "https://leetcode.com/problems/gas-station/",
                solutionJava = """
                public int canCompleteCircuit(int[] gas, int[] cost) {
                    int totalGas = 0, totalCost = 0, currentGas = 0, startIndex = 0;
                    for (int i = 0; i < gas.length; i++) {
                        totalGas += gas[i];
                        totalCost += cost[i];
                        currentGas += gas[i] - cost[i];
                        if (currentGas < 0) {
                            startIndex = i + 1;
                            currentGas = 0;
                        }
                    }
                    return totalGas < totalCost ? -1 : startIndex;
                }
            """.trimIndent(),
                solutionCpp = """
                int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
                    int totalGas = 0, totalCost = 0, currentGas = 0, startIndex = 0;
                    for (int i = 0; i < gas.size(); i++) {
                        totalGas += gas[i];
                        totalCost += cost[i];
                        currentGas += gas[i] - cost[i];
                        if (currentGas < 0) {
                            startIndex = i + 1;
                            currentGas = 0;
                        }
                    }
                    return totalGas < totalCost ? -1 : startIndex;
                }
            """.trimIndent()
            ),
            Question(
                name = "Assign Cookies",
                link = "https://leetcode.com/problems/assign-cookies/",
                solutionJava = """
                public int findContentChildren(int[] g, int[] s) {
                    Arrays.sort(g);
                    Arrays.sort(s);
                    int child = 0, cookie = 0;
                    while (child < g.length && cookie < s.length) {
                        if (g[child] <= s[cookie]) {
                            child++;
                        }
                        cookie++;
                    }
                    return child;
                }
            """.trimIndent(),
                solutionCpp = """
                int findContentChildren(vector<int>& g, vector<int>& s) {
                    sort(g.begin(), g.end());
                    sort(s.begin(), s.end());
                    int child = 0, cookie = 0;
                    while (child < g.size() && cookie < s.size()) {
                        if (g[child] <= s[cookie]) {
                            child++;
                        }
                        cookie++;
                    }
                    return child;
                }
            """.trimIndent()
            ),
            Question(
                name = "Lemonade Change",
                link = "https://leetcode.com/problems/lemonade-change/",
                solutionJava = """
                public boolean lemonadeChange(int[] bills) {
                    int five = 0, ten = 0;
                    for (int bill : bills) {
                        if (bill == 5) {
                            five++;
                        } else if (bill == 10) {
                            if (five == 0) return false;
                            five--;
                            ten++;
                        } else {
                            if (ten > 0 && five > 0) {
                                ten--;
                                five--;
                            } else if (five >= 3) {
                                five -= 3;
                            } else {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            """.trimIndent(),
                solutionCpp = """
                bool lemonadeChange(vector<int>& bills) {
                    int five = 0, ten = 0;
                    for (int bill : bills) {
                        if (bill == 5) {
                            five++;
                        } else if (bill == 10) {
                            if (five == 0) return false;
                            five--;
                            ten++;
                        } else {
                            if (ten > 0 && five > 0) {
                                ten--;
                                five--;
                            } else if (five >= 3) {
                                five -= 3;
                            } else {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            """.trimIndent()
            ),
            Question(
                name = "Maximum Subarray",
                link = "https://leetcode.com/problems/maximum-subarray/",
                solutionJava = """
                public int maxSubArray(int[] nums) {
                    int maxSoFar = nums[0], maxEndingHere = nums[0];
                    for (int i = 1; i < nums.length; i++) {
                        maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
                        maxSoFar = Math.max(maxSoFar, maxEndingHere);
                    }
                    return maxSoFar;
                }
            """.trimIndent(),
                solutionCpp = """
                int maxSubArray(vector<int>& nums) {
                    int maxSoFar = nums[0], maxEndingHere = nums[0];
                    for (int i = 1; i < nums.size(); i++) {
                        maxEndingHere = max(nums[i], maxEndingHere + nums[i]);
                        maxSoFar = max(maxSoFar, maxEndingHere);
                    }
                    return maxSoFar;
                }
            """.trimIndent()
            ),
            Question(
                name = "Partition Labels",
                link = "https://leetcode.com/problems/partition-labels/",
                solutionJava = """
                public List<Integer> partitionLabels(String s) {
                    int[] lastIndex = new int[26];
                    for (int i = 0; i < s.length(); i++) {
                        lastIndex[s.charAt(i) - 'a'] = i;
                    }
                    List<Integer> result = new ArrayList<>();
                    int j = 0, anchor = 0;
                    for (int i = 0; i < s.length(); i++) {
                        j = Math.max(j, lastIndex[s.charAt(i) - 'a']);
                        if (i == j) {
                            result.add(i - anchor + 1);
                            anchor = i + 1;
                        }
                    }
                    return result;
                }
            """.trimIndent(),
                solutionCpp = """
                vector<int> partitionLabels(string s) {
                    vector<int> lastIndex(26);
                    for (int i = 0; i < s.size(); i++) {
                        lastIndex[s[i] - 'a'] = i;
                    }
                    vector<int> result;
                    int j = 0, anchor = 0;
                    for (int i = 0; i < s.size(); i++) {
                        j = max(j, lastIndex[s[i] - 'a']);
                        if (i == j) {
                            result.push_back(i - anchor + 1);
                            anchor = i + 1;
                        }
                    }
                    return result;
                }
            """.trimIndent()
            ),
            Question(
                name = "Queue Reconstruction by Height",
                link = "https://leetcode.com/problems/queue-reconstruction-by-height/",
                solutionJava = """
                public int[][] reconstructQueue(int[][] people) {
                    Arrays.sort(people, (a, b) -> {
                        if (a[0] == b[0]) return a[1] - b[1];
                        return b[0] - a[0];
                    });
                    List<int[]> result = new ArrayList<>();
                    for (int[] person : people) {
                        result.add(person[1], person);
                    }
                    return result.toArray(new int[result.size()][]);
                }
            """.trimIndent(),
                solutionCpp = """
                vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
                    sort(people.begin(), people.end(), [](vector<int>& a, vector<int>& b) {
                        return a[0] == b[0] ? a[1] < b[1] : a[0] > b[0];
                    });
                    vector<vector<int>> result;
                    for (auto& person : people) {
                        result.insert(result.begin() + person[1], person);
                    }
                    return result;
                }
            """.trimIndent()
            ),
            Question(
                name = "Minimum Number of Arrows to Burst Balloons",
                link = "https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/",
                solutionJava = """
                public int findMinArrowShots(int[][] points) {
                    if (points.length == 0) return 0;
                    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
                    int arrows = 1, end = points[0][1];
                    for (int i = 1; i < points.length; i++) {
                        if (points[i][0] > end) {
                            arrows++;
                            end = points[i][1];
                        }
                    }
                    return arrows;
                }
            """.trimIndent(),
                solutionCpp = """
                int findMinArrowShots(vector<vector<int>>& points) {
                    if (points.empty()) return 0;
                    sort(points.begin(), points.end(), [](vector<int>& a, vector<int>& b) {
                        return a[1] < b[1];
                    });
                    int arrows = 1, end = points[0][1];
                    for (int i = 1; i < points.size(); i++) {
                        if (points[i][0] > end) {
                            arrows++;
                            end = points[i][1];
                        }
                    }
                    return arrows;
                }
            """.trimIndent()
            ),
            Question(
                name = "Non-overlapping Intervals",
                link = "https://leetcode.com/problems/non-overlapping-intervals/",
                solutionJava = """
                public int eraseOverlapIntervals(int[][] intervals) {
                    if (intervals.length == 0) return 0;
                    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
                    int count = 0, end = intervals[0][1];
                    for (int i = 1; i < intervals.length; i++) {
                        if (intervals[i][0] < end) {
                            count++;
                            end = Math.min(end, intervals[i][1]);
                        } else {
                            end = intervals[i][1];
                        }
                    }
                    return count;
                }
            """.trimIndent(),
                solutionCpp = """
                int eraseOverlapIntervals(vector<vector<int>>& intervals) {
                    if (intervals.empty()) return 0;
                    sort(intervals.begin(), intervals.end(), [](vector<int>& a, vector<int>& b) {
                        return a[0] < b[0];
                    });
                    int count = 0, end = intervals[0][1];
                    for (int i = 1; i < intervals.size(); i++) {
                        if (intervals[i][0] < end) {
                            count++;
                            end = min(end, intervals[i][1]);
                        } else {
                            end = intervals[i][1];
                        }
                    }
                    return count;
                }
            """.trimIndent()
            ),
            Question(
                name = "Task Scheduler",
                link = "https://leetcode.com/problems/task-scheduler/",
                solutionJava = """
                public int leastInterval(char[] tasks, int n) {
                    int[] counts = new int[26];
                    for (char task : tasks) {
                        counts[task - 'A']++;
                    }
                    Arrays.sort(counts);
                    int maxCount = counts[25];
                    int maxCountTasks = 1;
                    for (int i = 24; i >= 0; i--) {
                        if (counts[i] == maxCount) {
                            maxCountTasks++;
                        } else {
                            break;
                        }
                    }
                    return Math.max(tasks.length, (maxCount - 1) * (n + 1) + maxCountTasks);
                }
            """.trimIndent(),
                solutionCpp = """
                int leastInterval(vector<char>& tasks, int n) {
                    vector<int> counts(26, 0);
                    for (char task : tasks) {
                        counts[task - 'A']++;
                    }
                    sort(counts.begin(), counts.end());
                    int maxCount = counts[25];
                    int maxCountTasks = 1;
                    for (int i = 24; i >= 0; i--) {
                        if (counts[i] == maxCount) {
                            maxCountTasks++;
                        } else {
                            break;
                        }
                    }
                    return max(max((int)tasks.size(), (maxCount - 1) * (n + 1) + maxCountTasks));
                }
            """.trimIndent()
            ),
            Question(
                name = "Candy",
                link = "https://leetcode.com/problems/candy/",
                solutionJava = """
                public int candy(int[] ratings) {
                    int n = ratings.length;
                    int[] candies = new int[n];
                    Arrays.fill(candies, 1);
                    for (int i = 1; i < n; i++) {
                        if (ratings[i] > ratings[i - 1]) {
                            candies[i] = candies[i - 1] + 1;
                        }
                    }
                    for (int i = n - 2; i >= 0; i--) {
                        if (ratings[i] > ratings[i + 1]) {
                            candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                        }
                    }
                    int sum = 0;
                    for (int candy : candies) {
                        sum += candy;
                    }
                    return sum;
                }
            """.trimIndent(),
                solutionCpp = """
                int candy(vector<int>& ratings) {
                    int n = ratings.size();
                    vector<int> candies(n, 1);
                    for (int i = 1; i < n; i++) {
                        if (ratings[i] > ratings[i - 1]) {
                            candies[i] = candies[i - 1] + 1;
                        }
                    }
                    for (int i = n - 2; i >= 0; i--) {
                        if (ratings[i] > ratings[i + 1]) {
                            candies[i] = max(candies[i], candies[i + 1] + 1);
                        }
                    }
                    return accumulate(candies.begin(), candies.end(), 0);
                }
            """.trimIndent()
            ),
            Question(
                name = "Remove K Digits",
                link = "https://leetcode.com/problems/remove-k-digits/",
                solutionJava = """
                public String removeKdigits(String num, int k) {
                    StringBuilder sb = new StringBuilder();
                    for (char digit : num.toCharArray()) {
                        while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > digit) {
                            sb.deleteCharAt(sb.length() - 1);
                            k--;
                        }
                        sb.append(digit);
                    }
                    while (k > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                        k--;
                    }
                    while (sb.length() > 0 && sb.charAt(0) == '0') {
                        sb.deleteCharAt(0);
                    }
                    return sb.length() == 0 ? "0" : sb.toString();
                }
            """.trimIndent(),
                solutionCpp = """
                string removeKdigits(string num, int k) {
                    string result;
                    for (char digit : num) {
                        while (k > 0 && !result.empty() && result.back() > digit) {
                            result.pop_back();
                            k--;
                        }
                        result.push_back(digit);
                    }
                    while (k > 0 && !result.empty()) {
                        result.pop_back();
                        k--;
                    }
                    while (!result.empty() && result.front() == '0') {
                        result.erase(result.begin());
                    }
                    return result.empty() ? "0" : result;
                }
            """.trimIndent()
            ),
            Question(
                name = "Create Maximum Number",
                link = "https://leetcode.com/problems/create-maximum-number/",
                solutionJava = """
                public int[] maxNumber(int[] nums1, int[] nums2, int k) {
                    int[] result = new int[k];
                    for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
                        int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i));
                        if (greater(candidate, 0, result, 0)) {
                            result = candidate;
                        }
                    }
                    return result;
                }
                
                private int[] maxArray(int[] nums, int k) {
                    int n = nums.length;
                    int[] stack = new int[k];
                    int j = 0, drop = n - k;
                    for (int num : nums) {
                        while (j > 0 && drop > 0 && stack[j - 1] < num) {
                            j--;
                            drop--;
                        }
                        stack[j++] = num;
                    }
                    return stack;
                }
                
                private int[] merge(int[] nums1, int[] nums2) {
                    int[] merged = new int[nums1.length + nums2.length];
                    int i = 0, j = 0, index = 0;
                    while (i < nums1.length || j < nums2.length) {
                        if (greater(nums1, i, nums2, j)) {
                            merged[index++] = nums1[i++];
                        } else {
                            merged[index++] = nums2[j++];
                        }
                    }
                    return merged;
                }
                
                private boolean greater(int[] nums1, int i, int[] nums2, int j) {
                    while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                        i++;
                        j++;
                    }
                    return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
                }
            """.trimIndent(),
                solutionCpp = """
                vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
                    vector<int> result(k);
                    for (int i = max(0, k - (int)nums2.size()); i <= min(k, (int)nums1.size()); i++) {
                        vector<int> candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i));
                        if (greater(candidate, 0, result, 0)) {
                            result = candidate;
                        }
                    }
                    return result;
                }

                vector<int> maxArray(vector<int>& nums, int k) {
                    int n = nums.size();
                    vector<int> stack;
                    int drop = n - k;
                    for (int num : nums) {
                        while (drop > 0 && !stack.empty() && stack.back() < num) {
                            stack.pop_back();
                            drop--;
                        }
                        stack.push_back(num);
                    }
                    return vector<int>(stack.begin(), stack.begin() + k);
                }

                vector<int> merge(vector<int>& nums1, vector<int>& nums2) {
                    vector<int> merged;
                    int i = 0, j = 0;
                    while (i < nums1.size() || j < nums2.size()) {
                        if (greater(nums1, i, nums2, j)) {
                            merged.push_back(nums1[i++]);
                        } else {
                            merged.push_back(nums2[j++]);
                        }
                    }
                    return merged;
                }

                bool greater(vector<int>& nums1, int i, vector<int>& nums2, int j) {
                    while (i < nums1.size() && j < nums2.size() && nums1[i] == nums2[j]) {
                        i++;
                        j++;
                    }
                    return j == nums2.size() || (i < nums1.size() && nums1[i] > nums2[j]);
                }
            """.trimIndent()
            ),
            Question(
                name = "Minimum Deletions to Make Character Frequencies Unique",
                link = "https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/",
                solutionJava = """
                public int minDeletions(String s) {
                    int[] freq = new int[26];
                    for (char c : s.toCharArray()) {
                        freq[c - 'a']++;
                    }
                    Set<Integer> seen = new HashSet<>();
                    int deletions = 0;
                    for (int count : freq) {
                        while (count > 0 && seen.contains(count)) {
                            count--;
                            deletions++;
                        }
                        if (count > 0) seen.add(count);
                    }
                    return deletions;
                }
            """.trimIndent(),
                solutionCpp = """
                int minDeletions(string s) {
                    vector<int> freq(26, 0);
                    for (char c : s) {
                        freq[c - 'a']++;
                    }
                    unordered_set<int> seen;
                    int deletions = 0;
                    for (int count : freq) {
                        while (count > 0 && seen.count(count)) {
                            count--;
                            deletions++;
                        }
                        if (count > 0) seen.insert(count);
                    }
                    return deletions;
                }
            """.trimIndent()
            )
        )  // done
    ), Topic(
        topicName = "Binary Trees",
        topicDetails = "Problems involving binary tree data structure",
        questions = listOf(
            Question(
                name = "Maximum Depth of Binary Tree",
                link = "https://leetcode.com/problems/maximum-depth-of-binary-tree/",
                solutionJava = """
            public int maxDepth(TreeNode root) {
                if (root == null) return 0;
                return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
            }
        """.trimIndent(),
                solutionCpp = """
            int maxDepth(TreeNode* root) {
                if (!root) return 0;
                return 1 + max(maxDepth(root->left), maxDepth(root->right));
            }
        """.trimIndent()
            ),
            Question(
                name = "Invert Binary Tree",
                link = "https://leetcode.com/problems/invert-binary-tree/",
                solutionJava = """
            public TreeNode invertTree(TreeNode root) {
                if (root == null) return null;
                TreeNode left = invertTree(root.left);
                TreeNode right = invertTree(root.right);
                root.left = right;
                root.right = left;
                return root;
            }
        """.trimIndent(),
                solutionCpp = """
            TreeNode* invertTree(TreeNode* root) {
                if (!root) return nullptr;
                TreeNode* left = invertTree(root->left);
                TreeNode* right = invertTree(root->right);
                root->left = right;
                root->right = left;
                return root;
            }
        """.trimIndent()
            ),
            Question(
                name = "Symmetric Tree",
                link = "https://leetcode.com/problems/symmetric-tree/",
                solutionJava = """
            public boolean isSymmetric(TreeNode root) {
                return isMirror(root, root);
            }
            private boolean isMirror(TreeNode t1, TreeNode t2) {
                if (t1 == null && t2 == null) return true;
                if (t1 == null || t2 == null) return false;
                return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
            }
        """.trimIndent(),
                solutionCpp = """
            bool isSymmetric(TreeNode* root) {
                return isMirror(root, root);
            }
            bool isMirror(TreeNode* t1, TreeNode* t2) {
                if (!t1 && !t2) return true;
                if (!t1 || !t2) return false;
                return (t1->val == t2->val) && isMirror(t1->right, t2->left) && isMirror(t1->left, t2->right);
            }
        """.trimIndent()
            ),
            Question(
                name = "Binary Tree Level Order Traversal",
                link = "https://leetcode.com/problems/binary-tree-level-order-traversal/",
                solutionJava = """
            public List<List<Integer>> levelOrder(TreeNode root) {
                List<List<Integer>> result = new ArrayList<>();
                if (root == null) return result;
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                    int levelSize = queue.size();
                    List<Integer> currentLevel = new ArrayList<>();
                    for (int i = 0; i < levelSize; i++) {
                        TreeNode node = queue.poll();
                        currentLevel.add(node.val);
                        if (node.left != null) queue.add(node.left);
                        if (node.right != null) queue.add(node.right);
                    }
                    result.add(currentLevel);
                }
                return result;
            }
        """.trimIndent(),
                solutionCpp = """
            vector<vector<int>> levelOrder(TreeNode* root) {
                vector<vector<int>> result;
                if (!root) return result;
                queue<TreeNode*> q;
                q.push(root);
                while (!q.empty()) {
                    int levelSize = q.size();
                    vector<int> currentLevel;
                    for (int i = 0; i < levelSize; i++) {
                        TreeNode* node = q.front(); q.pop();
                        currentLevel.push_back(node->val);
                        if (node->left) q.push(node->left);
                        if (node->right) q.push(node->right);
                    }
                    result.push_back(currentLevel);
                }
                return result;
            }
        """.trimIndent()
            ),
            Question(
                name = "Construct Binary Tree from Preorder and Inorder Traversal",
                link = "https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/",
                solutionJava = """
            public TreeNode buildTree(int[] preorder, int[] inorder) {
                return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
            }
            private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
                if (preStart > preEnd || inStart > inEnd) return null;
                TreeNode root = new TreeNode(preorder[preStart]);
                int inRoot = 0;
                for (int i = inStart; i <= inEnd; i++) {
                    if (inorder[i] == root.val) {
                        inRoot = i;
                        break;
                    }
                }
                int leftTreeSize = inRoot - inStart;
                root.left = buildTree(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, inRoot - 1);
                root.right = buildTree(preorder, preStart + leftTreeSize + 1, preEnd, inorder, inRoot + 1, inEnd);
                return root;
            }
        """.trimIndent(),
                solutionCpp = """
            TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
                return buildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
            }
            TreeNode* buildTree(vector<int>& preorder, int preStart, int preEnd, vector<int>& inorder, int inStart, int inEnd) {
                if (preStart > preEnd || inStart > inEnd) return nullptr;
                TreeNode* root = new TreeNode(preorder[preStart]);
                int inRoot = 0;
                for (int i = inStart; i <= inEnd; i++) {
                    if (inorder[i] == root->val) {
                        inRoot = i;
                        break;
                    }
                }
                int leftTreeSize = inRoot - inStart;
                root->left = buildTree(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, inRoot - 1);
                root->right = buildTree(preorder, preStart + leftTreeSize + 1, preEnd, inorder, inRoot + 1, inEnd);
                return root;
            }
        """.trimIndent()
            ),
            Question(
                name = "Path Sum",
                link = "https://leetcode.com/problems/path-sum/",
                solutionJava = """
            public boolean hasPathSum(TreeNode root, int sum) {
                if (root == null) return sum == 0;
                sum -= root.val;
                if (root.left == null && root.right == null) return sum == 0;
                return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
            }
        """.trimIndent(),
                solutionCpp = """
            bool hasPathSum(TreeNode* root, int sum) {
                if (!root) return sum == 0;
                sum -= root->val;
                if (!root->left && !root->right) return sum == 0;
                return hasPathSum(root->left, sum) || hasPathSum(root->right, sum);
            }
        """.trimIndent()
            ),
            Question(
                name = "Binary Tree Maximum Path Sum",
                link = "https://leetcode.com/problems/binary-tree-maximum-path-sum/",
                solutionJava = """
            private int maxSum = Integer.MIN_VALUE;
            public int maxPathSum(TreeNode root) {
                maxPath(root);
                return maxSum;
            }
            private int maxPath(TreeNode node) {
                if (node == null) return 0;
                int left = Math.max(maxPath(node.left), 0);
                int right = Math.max(maxPath(node.right), 0);
                maxSum = Math.max(maxSum, node.val + left + right);
                return node.val + Math.max(left, right);
            }
        """.trimIndent(),
                solutionCpp = """
            int maxSum = INT_MIN;
            int maxPathSum(TreeNode* root) {
                maxPath(root);
                return maxSum;
            }
            int maxPath(TreeNode* node) {
                if (!node) return 0;
                int left = max(maxPath(node->left), 0);
                int right = max(maxPath(node->right), 0);
                maxSum = max(maxSum, node->val + left + right);
                return node->val + max(left, right);
            }
        """.trimIndent()
            ),
            Question(
                name = "Lowest Common Ancestor of a Binary Tree",
                link = "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/",
                solutionJava = """
            public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                if (root == null || root == p || root == q) return root;
                TreeNode left = lowestCommonAncestor(root.left, p, q);
                TreeNode right = lowestCommonAncestor(root.right, p, q);
                if (left != null && right != null) return root;
                return left != null ? left : right;
            }
        """.trimIndent(),
                solutionCpp = """
            TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
                if (!root || root == p || root == q) return root;
                TreeNode* left = lowestCommonAncestor(root->left, p, q);
                TreeNode* right = lowestCommonAncestor(root->right, p, q);
                if (left && right) return root;
                return left ? left : right;
            }
        """.trimIndent()
            ),
            Question(
                name = "Binary Tree Right Side View",
                link = "https://leetcode.com/problems/binary-tree-right-side-view/",
                solutionJava = """
            public List<Integer> rightSideView(TreeNode root) {
                List<Integer> result = new ArrayList<>();
                if (root == null) return result;
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                    int levelSize = queue.size();
                    for (int i = 0; i < levelSize; i++) {
                        TreeNode node = queue.poll();
                        if (i == levelSize - 1) result.add(node.val);
                        if (node.left != null) queue.add(node.left);
                        if (node.right != null) queue.add(node.right);
                    }
                }
                return result;
            }
        """.trimIndent(),
                solutionCpp = """
            vector<int> rightSideView(TreeNode* root) {
                vector<int> result;
                if (!root) return result;
                queue<TreeNode*> q;
                q.push(root);
                while (!q.empty()) {
                    int levelSize = q.size();
                    for (int i = 0; i < levelSize; i++) {
                        TreeNode* node = q.front(); q.pop();
                        if (i == levelSize - 1) result.push_back(node->val);
                        if (node->left) q.push(node->left);
                        if (node->right) q.push(node->right);
                    }
                }
                return result;
            }
        """.trimIndent()
            ),
            Question(
                name = "Serialize and Deserialize Binary Tree",
                link = "https://leetcode.com/problems/serialize-and-deserialize-binary-tree/",
                solutionJava = """
            public String serialize(TreeNode root) {
                StringBuilder sb = new StringBuilder();
                serializeHelper(root, sb);
                return sb.toString();
            }
            private void serializeHelper(TreeNode root, StringBuilder sb) {
                if (root == null) {
                    sb.append("null,");
                    return;
                }
                sb.append(root.val).append(',');
                serializeHelper(root.left, sb);
                serializeHelper(root.right, sb);
            }
            public TreeNode deserialize(String data) {
                String[] nodes = data.split(",");
                return deserializeHelper(nodes);
            }
            private TreeNode deserializeHelper(String[] nodes) {
                if (index >= nodes.length || nodes[index].equals("null")) {
                    index++;
                    return null;
                }
                TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));
                root.left = deserializeHelper(nodes);
                root.right = deserializeHelper(nodes);
                return root;
            }
        """.trimIndent(),
                solutionCpp = """
            string serialize(TreeNode* root) {
                stringstream ss;
                serializeHelper(root, ss);
                return ss.str();
            }
            void serializeHelper(TreeNode* root, stringstream& ss) {
                if (!root) {
                    ss << "null,";
                    return;
                }
                ss << root->val << ',';
                serializeHelper(root->left, ss);
                serializeHelper(root->right, ss);
            }
            TreeNode* deserialize(string data) {
                stringstream ss(data);
                return deserializeHelper(ss);
            }
            TreeNode* deserializeHelper(stringstream& ss) {
                string val;
                getline(ss, val, ',');
                if (val == "null") return nullptr;
                TreeNode* root = new TreeNode(stoi(val));
                root->left = deserializeHelper(ss);
                root->right = deserializeHelper(ss);
                return root;
            }
        """.trimIndent()
            ),
            Question(
                name = "Binary Tree Zigzag Level Order Traversal",
                link = "https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/",
                solutionJava = """
            public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
                List<List<Integer>> result = new ArrayList<>();
                if (root == null) return result;
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                boolean leftToRight = true;
                while (!queue.isEmpty()) {
                    int levelSize = queue.size();
                    List<Integer> currentLevel = new ArrayList<>();
                    for (int i = 0; i < levelSize; i++) {
                        TreeNode node = queue.poll();
                        if (leftToRight) {
                            currentLevel.add(node.val);
                        } else {
                            currentLevel.add(0, node.val);
                        }
                        if (node.left != null) queue.add(node.left);
                        if (node.right != null) queue.add(node.right);
                    }
                    result.add(currentLevel);
                    leftToRight = !leftToRight;
                }
                return result;
            }
        """.trimIndent(),
                solutionCpp = """
            vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
                vector<vector<int>> result;
                if (!root) return result;
                queue<TreeNode*> q;
                q.push(root);
                bool leftToRight = true;
                while (!q.empty()) {
                    int levelSize = q.size();
                    vector<int> currentLevel(levelSize);
                    for (int i = 0; i < levelSize; i++) {
                        TreeNode* node = q.front(); q.pop();
                        if (leftToRight) {
                            currentLevel[i] = node->val;
                        } else {
                            currentLevel[levelSize - 1 - i] = node->val;
                        }
                        if (node->left) q.push(node->left);
                        if (node->right) q.push(node->right);
                    }
                    result.push_back(currentLevel);
                    leftToRight = !leftToRight;
                }
                return result;
            }
        """.trimIndent()
            ),
            Question(
                name = "Flatten Binary Tree to Linked List",
                link = "https://leetcode.com/problems/flatten-binary-tree-to-linked-list/",
                solutionJava = """
            public void flatten(TreeNode root) {
                flattenTree(root);
            }
            private TreeNode flattenTree(TreeNode node) {
                if (node == null) return null;
                TreeNode left = flattenTree(node.left);
                TreeNode right = flattenTree(node.right);
                if (left != null) {
                    left.right = node.right;
                    node.right = node.left;
                    node.left = null;
                }
                return right != null ? right : left != null ? left : node;
            }
        """.trimIndent(),
                solutionCpp = """
            void flatten(TreeNode* root) {
                flattenTree(root);
            }
            TreeNode* flattenTree(TreeNode* node) {
                if (!node) return nullptr;
                TreeNode* left = flattenTree(node->left);
                TreeNode* right = flattenTree(node->right);
                if (left) {
                    left->right = node->right;
                    node->right = node->left;
                    node->left = nullptr;
                }
                return right ? right : left ? left : node;
            }
        """.trimIndent()
            ),
            Question(
                name = "Populating Next Right Pointers in Each Node",
                link = "https://leetcode.com/problems/populating-next-right-pointers-in-each-node/",
                solutionJava = """
            public void connect(Node root) {
                if (root == null) return;
                Queue<Node> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                    int levelSize = queue.size();
                    for (int i = 0; i < levelSize; i++) {
                        Node node = queue.poll();
                        if (i < levelSize - 1) {
                            node.next = queue.peek();
                        }
                        if (node.left != null) queue.add(node.left);
                        if (node.right != null) queue.add(node.right);
                    }
                }
            }
        """.trimIndent(),
                solutionCpp = """
            void connect(Node* root) {
                if (!root) return;
                queue<Node*> q;
                q.push(root);
                while (!q.empty()) {
                    int levelSize = q.size();
                    for (int i = 0; i < levelSize; i++) {
                        Node* node = q.front(); q.pop();
                        if (i < levelSize - 1) {
                            node->next = q.front();
                        }
                        if (node->left) q.push(node->left);
                        if (node->right) q.push(node->right);
                    }
                }
            }
        """.trimIndent()
            ),
            Question(
                name = "Validate Binary Tree Nodes",
                link = "https://leetcode.com/problems/validate-binary-tree-nodes/",
                solutionJava = """
            public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
                int[] indegree = new int[n];
                for (int i = 0; i < n; i++) {
                    if (leftChild[i] != -1) indegree[leftChild[i]]++;
                    if (rightChild[i] != -1) indegree[rightChild[i]]++;
                }
                int rootCount = 0;
                for (int i : indegree) {
                    if (i == 0) rootCount++;
                    if (i > 1) return false;
                }
                return rootCount == 1;
            }
        """.trimIndent(),
                solutionCpp = """
            bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
                vector<int> indegree(n, 0);
                for (int i = 0; i < n; i++) {
                    if (leftChild[i] != -1) indegree[leftChild[i]]++;
                    if (rightChild[i] != -1) indegree[rightChild[i]]++;
                }
                int rootCount = 0;
                for (int i : indegree) {
                    if (i == 0) rootCount++;
                    if (i > 1) return false;
                }
                return rootCount == 1;
            }
        """.trimIndent()
            ),
            Question(
                name = "Recover Binary Search Tree",
                link = "https://leetcode.com/problems/recover-binary-search-tree/",
                solutionJava = """
            public void recoverTree(TreeNode root) {
                TreeNode first = null, second = null, prev = null;
                inorderTraversal(root, prev, first, second);
                swap(first, second);
            }
            private void inorderTraversal(TreeNode root, TreeNode prev, TreeNode first, TreeNode second) {
                if (root == null) return;
                inorderTraversal(root.left, prev, first, second);
                if (prev != null && prev.val > root.val) {
                    if (first == null) first = prev;
                    second = root;
                }
                prev = root;
                inorderTraversal(root.right, prev, first, second);
            }
            private void swap(TreeNode first, TreeNode second) {
                int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }
        """.trimIndent(),
                solutionCpp = """
            void recoverTree(TreeNode* root) {
                TreeNode *first = nullptr, *second = nullptr, *prev = nullptr;
                inorderTraversal(root, prev, first, second);
                swap(first, second);
            }
            void inorderTraversal(TreeNode* root, TreeNode*& prev, TreeNode*& first, TreeNode*& second) {
                if (!root) return;
                inorderTraversal(root->left, prev, first, second);
                if (prev && prev->val > root->val) {
                    if (!first) first = prev;
                    second = root;
                }
                prev = root;
                inorderTraversal(root->right, prev, first, second);
            }
            void swap(TreeNode* first, TreeNode* second) {
                int temp = first->val;
                first->val = second->val;
                second->val = temp;
            }
        """.trimIndent()
            )
        )     // done
    ), Topic(
        topicName = "Binary Search Trees",
        topicDetails = "Problems specific to binary search tree data structure",
        questions = listOf(
            Question(
                name = "Validate Binary Search Tree",
                link = "https://leetcode.com/problems/validate-binary-search-tree/",
                solutionJava = """
            class Solution {
                public boolean isValidBST(TreeNode root) {
                    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
                }

                private boolean isValid(TreeNode node, long min, long max) {
                    if (node == null) return true;
                    if (node.val <= min || node.val >= max) return false;
                    return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
                }
            }
        """,
                solutionCpp = """
            class Solution {
            public:
                bool isValidBST(TreeNode* root) {
                    return isValid(root, LONG_MIN, LONG_MAX);
                }

                bool isValid(TreeNode* node, long min, long max) {
                    if (!node) return true;
                    if (node->val <= min || node->val >= max) return false;
                    return isValid(node->left, min, node->val) && isValid(node->right, node->val, max);
                }
            };
        """
            ),
            Question(
                name = "Lowest Common Ancestor of a Binary Search Tree",
                link = "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/",
                solutionJava = """
            class Solution {
                public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                    while (root != null) {
                        if (root.val > p.val && root.val > q.val) {
                            root = root.left;
                        } else if (root.val < p.val && root.val < q.val) {
                            root = root.right;
                        } else {
                            return root;
                        }
                    }
                    return null;
                }
            }
        """,
                solutionCpp = """
            class Solution {
            public:
                TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
                    while (root) {
                        if (root->val > p->val && root->val > q->val) {
                            root = root->left;
                        } else if (root->val < p->val && root->val < q->val) {
                            root = root->right;
                        } else {
                            return root;
                        }
                    }
                    return nullptr;
                }
            };
        """
            ),
            Question(
                name = "Kth Smallest Element in a BST",
                link = "https://leetcode.com/problems/kth-smallest-element-in-a-bst/",
                solutionJava = """
            class Solution {
                private int count = 0, result = 0;

                public int kthSmallest(TreeNode root, int k) {
                    inOrderTraversal(root, k);
                    return result;
                }

                private void inOrderTraversal(TreeNode node, int k) {
                    if (node == null) return;
                    inOrderTraversal(node.left, k);
                    count++;
                    if (count == k) {
                        result = node.val;
                        return;
                    }
                    inOrderTraversal(node.right, k);
                }
            }
        """,
                solutionCpp = """
            class Solution {
            private:
                int count = 0, result = 0;

                void inOrderTraversal(TreeNode* node, int k) {
                    if (!node) return;
                    inOrderTraversal(node->left, k);
                    count++;
                    if (count == k) {
                        result = node->val;
                        return;
                    }
                    inOrderTraversal(node->right, k);
                }

            public:
                int kthSmallest(TreeNode* root, int k) {
                    inOrderTraversal(root, k);
                    return result;
                }
            };
        """
            ),
            Question(
                name = "Convert Sorted Array to Binary Search Tree",
                link = "https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/",
                solutionJava = """
            class Solution {
                public TreeNode sortedArrayToBST(int[] nums) {
                    return convert(nums, 0, nums.length - 1);
                }

                private TreeNode convert(int[] nums, int left, int right) {
                    if (left > right) return null;
                    int mid = left + (right - left) / 2;
                    TreeNode node = new TreeNode(nums[mid]);
                    node.left = convert(nums, left, mid - 1);
                    node.right = convert(nums, mid + 1, right);
                    return node;
                }
            }
        """,
                solutionCpp = """
            class Solution {
            public:
                TreeNode* sortedArrayToBST(vector<int>& nums) {
                    return convert(nums, 0, nums.size() - 1);
                }

                TreeNode* convert(vector<int>& nums, int left, int right) {
                    if (left > right) return nullptr;
                    int mid = left + (right - left) / 2;
                    TreeNode* node = new TreeNode(nums[mid]);
                    node->left = convert(nums, left, mid - 1);
                    node->right = convert(nums, mid + 1, right);
                    return node;
                }
            };
        """
            ),
            Question(
                name = "Delete Node in a BST",
                link = "https://leetcode.com/problems/delete-node-in-a-bst/",
                solutionJava = """
            class Solution {
                public TreeNode deleteNode(TreeNode root, int key) {
                    if (root == null) return null;
                    if (key < root.val) {
                        root.left = deleteNode(root.left, key);
                    } else if (key > root.val) {
                        root.right = deleteNode(root.right, key);
                    } else {
                        if (root.left == null) return root.right;
                        if (root.right == null) return root.left;
                        TreeNode minNode = getMin(root.right);
                        root.val = minNode.val;
                        root.right = deleteNode(root.right, minNode.val);
                    }
                    return root;
                }

                private TreeNode getMin(TreeNode node) {
                    while (node.left != null) node = node.left;
                    return node;
                }
            }
        """,
                solutionCpp = """
            class Solution {
            public:
                TreeNode* deleteNode(TreeNode* root, int key) {
                    if (!root) return nullptr;
                    if (key < root->val) {
                        root->left = deleteNode(root->left, key);
                    } else if (key > root->val) {
                        root->right = deleteNode(root->right, key);
                    } else {
                        if (!root->left) return root->right;
                        if (!root->right) return root->left;
                        TreeNode* minNode = getMin(root->right);
                        root->val = minNode->val;
                        root->right = deleteNode(root->right, minNode->val);
                    }
                    return root;
                }

                TreeNode* getMin(TreeNode* node) {
                    while (node->left) node = node->left;
                    return node;
                }
            };
        """
            ),
            Question(
                name = "Binary Search Tree Iterator",
                link = "https://leetcode.com/problems/binary-search-tree-iterator/",
                solutionJava = """
            class BSTIterator {
                private Stack<TreeNode> stack;

                public BSTIterator(TreeNode root) {
                    stack = new Stack<>();
                    pushAll(root);
                }

                public int next() {
                    TreeNode node = stack.pop();
                    pushAll(node.right);
                    return node.val;
                }

                public boolean hasNext() {
                    return !stack.isEmpty();
                }

                private void pushAll(TreeNode node) {
                    for (; node != null; stack.push(node), node = node.left);
                }
            }
        """,
                solutionCpp = """
            class BSTIterator {
            private:
                stack<TreeNode*> stack;

                void pushAll(TreeNode* node) {
                    while (node) {
                        stack.push(node);
                        node = node->left;
                    }
                }

            public:
                BSTIterator(TreeNode* root) {
                    pushAll(root);
                }

                int next() {
                    TreeNode* node = stack.top();
                    stack.pop();
                    pushAll(node->right);
                    return node->val;
                }

                bool hasNext() {
                    return !stack.empty();
                }
            };
        """
            ),
            Question(
                name = "Unique Binary Search Trees",
                link = "https://leetcode.com/problems/unique-binary-search-trees/",
                solutionJava = """
            class Solution {
                public int numTrees(int n) {
                    int[] dp = new int[n + 1];
                    dp[0] = dp[1] = 1;
                    for (int i = 2; i <= n; i++) {
                        for (int j = 1; j <= i; j++) {
                            dp[i] += dp[j - 1] * dp[i - j];
                        }
                    }
                    return dp[n];
                }
            }
        """,
                solutionCpp = """
            class Solution {
            public:
                int numTrees(int n) {
                    vector<int> dp(n + 1);
                    dp[0] = dp[1] = 1;
                    for (int i = 2; i <= n; i++) {
                        for (int j = 1; j <= i; j++) {
                            dp[i] += dp[j - 1] * dp[i - j];
                        }
                    }
                    return dp[n];
                }
            };
        """
            ),
            Question(
                name = "Recover Binary Search Tree",
                link = "https://leetcode.com/problems/recover-binary-search-tree/",
                solutionJava = """
            class Solution {
                private TreeNode first, second, prev;

                public void recoverTree(TreeNode root) {
                    inOrderTraversal(root);
                    int temp = first.val;
                    first.val = second.val;
                    second.val = temp;
                }

                private void inOrderTraversal(TreeNode node) {
                    if (node == null) return;
                    inOrderTraversal(node.left);
                    if (prev != null && prev.val > node.val) {
                        if (first == null) first = prev;
                        second = node;
                    }
                    prev = node;
                    inOrderTraversal(node.right);
                }
            }
        """,
                solutionCpp = """
            class Solution {
            private:
                TreeNode *first, *second, *prev;

                void inOrderTraversal(TreeNode* node) {
                    if (!node) return;
                    inOrderTraversal(node->left);
                    if (prev && prev->val > node->val) {
                        if (!first) first = prev;
                        second = node;
                    }
                    prev = node;
                    inOrderTraversal(node->right);
                }

            public:
                void recoverTree(TreeNode* root) {
                    first = second = prev = nullptr;
                    inOrderTraversal(root);
                    swap(first->val, second->val);
                }
            };
        """
            ),
            Question(
                name = "Balanced Binary Tree",
                link = "https://leetcode.com/problems/balanced-binary-tree/",
                solutionJava = """
            class Solution {
                public boolean isBalanced(TreeNode root) {
                    return checkBalance(root) != -1;
                }

                private int checkBalance(TreeNode node) {
                    if (node == null) return 0;
                    int leftHeight = checkBalance(node.left);
                    if (leftHeight == -1) return -1;
                    int rightHeight = checkBalance(node.right);
                    if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;
                    return Math.max(leftHeight, rightHeight) + 1;
                }
            }
        """,
                solutionCpp = """
            class Solution {
            public:
                bool isBalanced(TreeNode* root) {
                    return checkBalance(root) != -1;
                }

                int checkBalance(TreeNode* node) {
                    if (!node) return 0;
                    int leftHeight = checkBalance(node->left);
                    if (leftHeight == -1) return -1;
                    int rightHeight = checkBalance(node->right);
                    if (rightHeight == -1 || abs(leftHeight - rightHeight) > 1) return -1;
                    return max(leftHeight, rightHeight) + 1;
                }
            };
        """
            ),
            Question(
                name = "Convert BST to Greater Tree",
                link = "https://leetcode.com/problems/convert-bst-to-greater-tree/",
                solutionJava = """
            class Solution {
                private int sum = 0;

                public TreeNode convertBST(TreeNode root) {
                    reverseInOrderTraversal(root);
                    return root;
                }

                private void reverseInOrderTraversal(TreeNode node) {
                    if (node == null) return;
                    reverseInOrderTraversal(node.right);
                    sum += node.val;
                    node.val = sum;
                    reverseInOrderTraversal(node.left);
                }
            }
        """,
                solutionCpp = """
            class Solution {
            private:
                int sum = 0;

                void reverseInOrderTraversal(TreeNode* node) {
                    if (!node) return;
                    reverseInOrderTraversal(node->right);
                    sum += node->val;
                    node->val = sum;
                    reverseInOrderTraversal(node->left);
                }

            public:
                TreeNode* convertBST(TreeNode* root) {
                    reverseInOrderTraversal(root);
                    return root;
                }
            };
        """
            ),
            Question(
                name = "Trim a Binary Search Tree",
                link = "https://leetcode.com/problems/trim-a-binary-search-tree/",
                solutionJava = """
            class Solution {
                public TreeNode trimBST(TreeNode root, int low, int high) {
                    if (root == null) return null;
                    if (root.val < low) return trimBST(root.right, low, high);
                    if (root.val > high) return trimBST(root.left, low, high);
                    root.left = trimBST(root.left, low, high);
                    root.right = trimBST(root.right, low, high);
                    return root;
                }
            }
        """,
                solutionCpp = """
            class Solution {
            public:
                TreeNode* trimBST(TreeNode* root, int low, int high) {
                    if (!root) return nullptr;
                    if (root->val < low) return trimBST(root->right, low, high);
                    if (root->val > high) return trimBST(root->left, low, high);
                    root->left = trimBST(root->left, low, high);
                    root->right = trimBST(root->right, low, high);
                    return root;
                }
            };
        """
            ),
            Question(
                name = "Range Sum of BST",
                link = "https://leetcode.com/problems/range-sum-of-bst/",
                solutionJava = """
            class Solution {
                public int rangeSumBST(TreeNode root, int low, int high) {
                    if (root == null) return 0;
                    if (root.val < low) return rangeSumBST(root.right, low, high);
                    if (root.val > high) return rangeSumBST(root.left, low, high);
                    return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
                }
            }
        """,
                solutionCpp = """
            class Solution {
            public:
                int rangeSumBST(TreeNode* root, int low, int high) {
                    if (!root) return 0;
                    if (root->val < low) return rangeSumBST(root->right, low, high);
                    if (root->val > high) return rangeSumBST(root->left, low, high);
                    return root->val + rangeSumBST(root->left, low, high) + rangeSumBST(root->right, low, high);
                }
            };
        """
            ),
            Question(
                name = "Construct Binary Search Tree from Preorder Traversal",
                link = "https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/",
                solutionJava = """
            class Solution {
                public TreeNode bstFromPreorder(int[] preorder) {
                    return construct(preorder, 0, preorder.length - 1);
                }

                private TreeNode construct(int[] preorder, int left, int right) {
                    if (left > right) return null;
                    TreeNode node = new TreeNode(preorder[left]);
                    int i = left + 1;
                    while (i <= right && preorder[i] < preorder[left]) i++;
                    node.left = construct(preorder, left + 1, i - 1);
                    node.right = construct(preorder, i, right);
                    return node;
                }
            }
        """,
                solutionCpp = """
            class Solution {
            public:
                TreeNode* bstFromPreorder(vector<int>& preorder) {
                    return construct(preorder, 0, preorder.size() - 1);
                }

                TreeNode* construct(vector<int>& preorder, int left, int right) {
                    if (left > right) return nullptr;
                    TreeNode* node = new TreeNode(preorder[left]);
                    int i = left + 1;
                    while (i <= right && preorder[i] < preorder[left]) i++;
                    node->left = construct(preorder, left + 1, i - 1);
                    node->right = construct(preorder, i, right);
                    return node;
                }
            };
        """
            ),
            Question(
                name = "Serialize and Deserialize BST",
                link = "https://leetcode.com/problems/serialize-and-deserialize-bst/",
                solutionJava = """
            class Codec {
                // Encodes a tree to a single string.
                public String serialize(TreeNode root) {
                    StringBuilder sb = new StringBuilder();
                    serializeHelper(root, sb);
                    return sb.toString();
                }

                private void serializeHelper(TreeNode node, StringBuilder sb) {
                    if (node == null) {
                        sb.append("null,");
                        return;
                    }
                    sb.append(node.val).append(",");
                    serializeHelper(node.left, sb);
                    serializeHelper(node.right, sb);
                }

                // Decodes your encoded data to tree.
                public TreeNode deserialize(String data) {
                    String[] nodes = data.split(",");
                    Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
                    return deserializeHelper(queue);
                }

                private TreeNode deserializeHelper(Queue<String> queue) {
                    if (queue.isEmpty()) return null;
                    String val = queue.poll();
                    if (val.equals("null")) return null;
                    TreeNode node = new TreeNode(Integer.parseInt(val));
                    node.left = deserializeHelper(queue);
                    node.right = deserializeHelper(queue);
                    return node;
                }
            }
        """,
                solutionCpp = """
            class Codec {
            public:
                // Encodes a tree to a single string.
                string serialize(TreeNode* root) {
                    string res;
                    serializeHelper(root, res);
                    return res;
                }

                void serializeHelper(TreeNode* node, string& res) {
                    if (!node) {
                        res += "null,";
                        return;
                    }
                    res += to_string(node->val) + ",";
                    serializeHelper(node->left, res);
                    serializeHelper(node->right, res);
                }

                // Decodes your encoded data to tree.
                TreeNode* deserialize(string data) {
                    istringstream ss(data);
                    return deserializeHelper(ss);
                }

                TreeNode* deserializeHelper(istringstream& ss) {
                    string val;
                    if (!getline(ss, val, ',')) return nullptr;
                    if (val == "null") return nullptr;
                    TreeNode* node = new TreeNode(stoi(val));
                    node->left = deserializeHelper(ss);
                    node->right = deserializeHelper(ss);
                    return node;
                }
            };
        """
            ),
            Question(
                name = "Closest Binary Search Tree Value",
                link = "https://leetcode.com/problems/closest-binary-search-tree-value/",
                solutionJava = """
            class Solution {
                public int closestValue(TreeNode root, double target) {
                    int closest = root.val;
                    while (root != null) {
                        if (Math.abs(target - root.val) < Math.abs(target - closest)) {
                            closest = root.val;
                        }
                        root = target < root.val ? root.left : root.right;
                    }
                    return closest;
                }
            }
        """,
                solutionCpp = """
            class Solution {
            public:
                int closestValue(TreeNode* root, double target) {
                    int closest = root->val;
                    while (root) {
                        if (abs(target - root->val) < abs(target - closest)) {
                            closest = root->val;
                        }
                        root = target < root->val ? root->left : root->right;
                    }
                    return closest;
                }
            };
        """
            )
        ) // done
    ), Topic(
        topicName = "Graphs",
        topicDetails = "Problems involving graph data structures and algorithms",
        questions = listOf(
            Question(
                name = "Number of Islands",
                link = "https://leetcode.com/problems/number-of-islands/",
                solutionJava = """
            public int numIslands(char[][] grid) {
                if (grid == null || grid.length == 0) return 0;
                int count = 0;
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == '1') {
                            count++;
                            dfs(grid, i, j);
                        }
                    }
                }
                return count;
            }
            private void dfs(char[][] grid, int i, int j) {
                if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
                    return;
                }
                grid[i][j] = '0'; // mark as visited
                dfs(grid, i - 1, j);
                dfs(grid, i + 1, j);
                dfs(grid, i, j - 1);
                dfs(grid, i, j + 1);
            }
        """.trimIndent(),
                solutionCpp = """
            int numIslands(vector<vector<char>>& grid) {
                if (grid.empty()) return 0;
                int count = 0;
                for (int i = 0; i < grid.size(); i++) {
                    for (int j = 0; j < grid[0].size(); j++) {
                        if (grid[i][j] == '1') {
                            count++;
                            dfs(grid, i, j);
                        }
                    }
                }
                return count;
            }
            void dfs(vector<vector<char>>& grid, int i, int j) {
                if (i < 0 || j < 0 || i >= grid.size() || j >= grid[0].size() || grid[i][j] == '0') {
                    return;
                }
                grid[i][j] = '0'; // mark as visited
                dfs(grid, i - 1, j);
                dfs(grid, i + 1, j);
                dfs(grid, i, j - 1);
                dfs(grid, i, j + 1);
            }
        """.trimIndent()
            ),
            Question(
                name = "Clone Graph",
                link = "https://leetcode.com/problems/clone-graph/",
                solutionJava = """
            public Node cloneGraph(Node node) {
                if (node == null) return null;
                Map<Node, Node> map = new HashMap<>();
                return clone(node, map);
            }
            private Node clone(Node node, Map<Node, Node> map) {
                if (map.containsKey(node)) return map.get(node);
                Node newNode = new Node(node.val);
                map.put(node, newNode);
                for (Node neighbor : node.neighbors) {
                    newNode.neighbors.add(clone(neighbor, map));
                }
                return newNode;
            }
        """.trimIndent(),
                solutionCpp = """
            Node* cloneGraph(Node* node) {
                if (!node) return nullptr;
                unordered_map<Node*, Node*> map;
                return clone(node, map);
            }
            Node* clone(Node* node, unordered_map<Node*, Node*>& map) {
                if (map.count(node)) return map[node];
                Node* newNode = new Node(node->val);
                map[node] = newNode;
                for (Node* neighbor : node->neighbors) {
                    newNode->neighbors.push_back(clone(neighbor, map));
                }
                return newNode;
            }
        """.trimIndent()
            ),
            Question(
                name = "Course Schedule",
                link = "https://leetcode.com/problems/course-schedule/",
                solutionJava = """
            public boolean canFinish(int numCourses, int[][] prerequisites) {
                int[] indegree = new int[numCourses];
                List<List<Integer>> graph = new ArrayList<>();
                for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
                for (int[] edge : prerequisites) {
                    graph.get(edge[1]).add(edge[0]);
                    indegree[edge[0]]++;
                }
                Queue<Integer> queue = new LinkedList<>();
                for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) queue.add(i);
                int count = 0;
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    count++;
                    for (int neighbor : graph.get(curr)) {
                        indegree[neighbor]--;
                        if (indegree[neighbor] == 0) queue.add(neighbor);
                    }
                }
                return count == numCourses;
            }
        """.trimIndent(),
                solutionCpp = """
            bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
                vector<int> indegree(numCourses, 0);
                vector<vector<int>> graph(numCourses);
                for (const auto& edge : prerequisites) {
                    graph[edge[1]].push_back(edge[0]);
                    indegree[edge[0]]++;
                }
                queue<int> q;
                for (int i = 0; i < numCourses; i++) {
                    if (indegree[i] == 0) q.push(i);
                }
                int count = 0;
                while (!q.empty()) {
                    int curr = q.front();
                    q.pop();
                    count++;
                    for (int neighbor : graph[curr]) {
                        indegree[neighbor]--;
                        if (indegree[neighbor] == 0) q.push(neighbor);
                    }
                }
                return count == numCourses;
            }
        """.trimIndent()
            ),
            Question(
                name = "Pacific Atlantic Water Flow",
                link = "https://leetcode.com/problems/pacific-atlantic-water-flow/",
                solutionJava = """
            public List<List<Integer>> pacificAtlantic(int[][] heights) {
                List<List<Integer>> result = new ArrayList<>();
                if (heights.length == 0 || heights[0].length == 0) return result;
                int rows = heights.length, cols = heights[0].length;
                boolean[][] pacific = new boolean[rows][cols];
                boolean[][] atlantic = new boolean[rows][cols];
                for (int i = 0; i < rows; i++) {
                    dfs(heights, pacific, i, 0);
                    dfs(heights, atlantic, i, cols - 1);
                }
                for (int j = 0; j < cols; j++) {
                    dfs(heights, pacific, 0, j);
                    dfs(heights, atlantic, rows - 1, j);
                }
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (pacific[i][j] && atlantic[i][j]) {
                            result.add(Arrays.asList(i, j));
                        }
                    }
                }
                return result;
            }
            private void dfs(int[][] heights, boolean[][] ocean, int i, int j) {
                ocean[i][j] = true;
                int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                for (int[] d : directions) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni >= 0 && nj >= 0 && ni < heights.length && nj < heights[0].length &&
                        heights[ni][nj] >= heights[i][j] && !ocean[ni][nj]) {
                        dfs(heights, ocean, ni, nj);
                    }
                }
            }
        """.trimIndent(),
                solutionCpp = """
            vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
                vector<vector<int>> result;
                if (heights.empty()) return result;
                int rows = heights.size(), cols = heights[0].size();
                vector<vector<bool>> pacific(rows, vector<bool>(cols, false));
                vector<vector<bool>> atlantic(rows, vector<bool>(cols, false));
                for (int i = 0; i < rows; i++) {
                    dfs(heights, pacific, i, 0);
                    dfs(heights, atlantic, i, cols - 1);
                }
                for (int j = 0; j < cols; j++) {
                    dfs(heights, pacific, 0, j);
                    dfs(heights, atlantic, rows - 1, j);
                }
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (pacific[i][j] && atlantic[i][j]) {
                            result.push_back({i, j});
                        }
                    }
                }
                return result;
            }
            void dfs(vector<vector<int>>& heights, vector<vector<bool>>& ocean, int i, int j) {
                ocean[i][j] = true;
                vector<vector<int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                for (auto& d : directions) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni >= 0 && nj >= 0 && ni < heights.size() && nj < heights[0].size() &&
                        heights[ni][nj] >= heights[i][j] && !ocean[ni][nj]) {
                        dfs(heights, ocean, ni, nj);
                    }
                }
            }
        """.trimIndent()
            ),
            Question(
                name = "Graph Valid Tree",
                link = "https://leetcode.com/problems/graph-valid-tree/",
                solutionJava = """
            public boolean validTree(int n, int[][] edges) {
                if (n == 0) return edges.length == 0;
                if (edges.length != n - 1) return false;
                List<List<Integer>> graph = new ArrayList<>();
                for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
                for (int[] edge : edges) {
                    graph.get(edge[0]).add(edge[1]);
                    graph.get(edge[1]).add(edge[0]);
                }
                boolean[] visited = new boolean[n];
                int count = dfs(graph, 0, visited);
                return count == n;
            }
            private int dfs(List<List<Integer>> graph, int node, boolean[] visited) {
                visited[node] = true;
                int count = 1;
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        count += dfs(graph, neighbor, visited);
                    }
                }
                return count;
            }
        """.trimIndent(),
                solutionCpp = """
            bool validTree(int n, vector<vector<int>>& edges) {
                if (n == 0) return edges.empty();
                if (edges.size() != n - 1) return false;
                vector<vector<int>> graph(n);
                for (const auto& edge : edges) {
                    graph[edge[0]].push_back(edge[1]);
                    graph[edge[1]].push_back(edge[0]);
                }
                vector<bool> visited(n, false);
                int count = dfs(graph, 0, visited);
                return count == n;
            }
            int dfs(vector<vector<int>>& graph, int node, vector<bool>& visited) {
                visited[node] = true;
                int count = 1;
                for (int neighbor : graph[node]) {
                    if (!visited[neighbor]) {
                        count += dfs(graph, neighbor, visited);
                    }
                }
                return count;
            }
        """.trimIndent()
            ),
            Question(
                name = "Word Ladder",
                link = "https://leetcode.com/problems/word-ladder/",
                solutionJava = """
            public int ladderLength(String beginWord, String endWord, List<String> wordList) {
                Set<String> wordSet = new HashSet<>(wordList);
                if (!wordSet.contains(endWord)) return 0;
                Queue<String> queue = new LinkedList<>();
                queue.add(beginWord);
                int level = 1;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        String word = queue.poll();
                        if (word.equals(endWord)) return level;
                        for (int j = 0; j < word.length(); j++) {
                            char[] charArray = word.toCharArray();
                            for (char c = 'a'; c <= 'z'; c++) {
                                charArray[j] = c;
                                String newWord = new String(charArray);
                                if (wordSet.contains(newWord)) {
                                    queue.add(newWord);
                                    wordSet.remove(newWord);
                                }
                            }
                        }
                    }
                    level++;
                }
                return 0;
            }
        """.trimIndent(),
                solutionCpp = """
            int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
                unordered_set<string> wordSet(wordList.begin(), wordList.end());
                if (!wordSet.count(endWord)) return 0;
                queue<string> q;
                q.push(beginWord);
                int level = 1;
                while (!q.empty()) {
                    int size = q.size();
                    for (int i = 0; i < size; i++) {
                        string word = q.front();
                        q.pop();
                        if (word == endWord) return level;
                        for (int j = 0; j < word.length(); j++) {
                            string newWord = word;
                            for (char c = 'a'; c <= 'z'; c++) {
                                newWord[j] = c;
                                if (wordSet.count(newWord)) {
                                    q.push(newWord);
                                    wordSet.erase(newWord);
                                }
                            }
                        }
                    }
                    level++;
                }
                return 0;
            }
        """.trimIndent()
            ),
            Question(
                name = "Alien Dictionary",
                link = "https://leetcode.com/problems/alien-dictionary/",
                solutionJava = """
            public String alienOrder(String[] words) {
                Map<Character, Set<Character>> graph = new HashMap<>();
                int[] indegree = new int[26];
                Arrays.fill(indegree, 0);
                buildGraph(words, graph, indegree);
                return topologicalSort(graph, indegree);
            }
            private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] indegree) {
                for (String word : words) {
                    for (char c : word.toCharArray()) {
                        graph.putIfAbsent(c, new HashSet<>());
                    }
                }
                for (int i = 0; i < words.length - 1; i++) {
                    String w1 = words[i], w2 = words[i + 1];
                    for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                        if (w1.charAt(j) != w2.charAt(j)) {
                            graph.get(w1.charAt(j)).add(w2.charAt(j));
                            indegree[w2.charAt(j) - 'a']++;
                            break;
                        }
                    }
                }
            }
            private String topologicalSort(Map<Character, Set<Character>> graph, int[] indegree) {
                StringBuilder sb = new StringBuilder();
                Queue<Character> queue = new LinkedList<>();
                for (char c : graph.keySet()) {
                    if (indegree[c - 'a'] == 0) queue.add(c);
                }
                while (!queue.isEmpty()) {
                    char curr = queue.poll();
                    sb.append(curr);
                    for (char neighbor : graph.get(curr)) {
                        indegree[neighbor - 'a']--;
                        if (indegree[neighbor - 'a'] == 0) queue.add(neighbor);
                    }
                }
                return sb.length() == graph.size() ? sb.toString() : "";
            }
        """.trimIndent(),
                solutionCpp = """
            string alienOrder(vector<string>& words) {
                unordered_map<char, unordered_set<char>> graph;
                vector<int> indegree(26, 0);
                buildGraph(words, graph, indegree);
                return topologicalSort(graph, indegree);
            }
            void buildGraph(vector<string>& words, unordered_map<char, unordered_set<char>>& graph, vector<int>& indegree) {
                for (const string& word : words) {
                    for (char c : word) {
                        graph[c];
                    }
                }
                for (int i = 0; i < words.size() - 1; i++) {
                    const string& w1 = words[i], & w2 = words[i + 1];
                    for (int j = 0; j < min(w1.size(), w2.size()); j++) {
                        if (w1[j] != w2[j]) {
                            if (graph[w1[j]].insert(w2[j]).second) {
                                indegree[w2[j] - 'a']++;
                            }
                            break;
                        }
                    }
                }
            }
            string topologicalSort(const unordered_map<char, unordered_set<char>>& graph, vector<int>& indegree) {
                string result;
                queue<char> q;
                for (char c : graph) {
                    if (indegree[c - 'a'] == 0) q.push(c);
                }
                while (!q.empty()) {
                    char curr = q.front();
                    q.pop();
                    result += curr;
                    for (char neighbor : graph.at(curr)) {
                        indegree[neighbor - 'a']--;
                        if (indegree[neighbor - 'a'] == 0) q.push(neighbor);
                    }
                }
                return result.size() == graph.size() ? result : "";
            }
        """.trimIndent()
            ),
            Question(
                name = "Network Delay Time",
                link = "https://leetcode.com/problems/network-delay-time/",
                solutionJava = """
            public int networkDelayTime(int[][] times, int n, int k) {
                Map<Integer, List<int[]>> graph = new HashMap<>();
                for (int[] time : times) {
                    graph.putIfAbsent(time[0], new ArrayList<>());
                    graph.get(time[0]).add(new int[]{time[1], time[2]});
                }
                PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
                pq.offer(new int[]{k, 0});
                int[] dist = new int[n + 1];
                Arrays.fill(dist, Integer.MAX_VALUE);
                dist[k] = 0;
                while (!pq.isEmpty()) {
                    int[] curr = pq.poll();
                    int node = curr[0], time = curr[1];
                    if (time > dist[node]) continue;
                    for (int[] edge : graph.getOrDefault(node, new ArrayList<>())) {
                        int neighbor = edge[0], newTime = time + edge[1];
                        if (newTime < dist[neighbor]) {
                            dist[neighbor] = newTime;
                            pq.offer(new int[]{neighbor, newTime});
                        }
                    }
                }
                int maxTime = 0;
                for (int i = 1; i <= n; i++) {
                    if (dist[i] == Integer.MAX_VALUE) return -1;
                    maxTime = Math.max(maxTime, dist[i]);
                }
                return maxTime;
            }
        """.trimIndent(),
                solutionCpp = """
            int networkDelayTime(vector<vector<int>>& times, int n, int k) {
                unordered_map<int, vector<pair<int, int>>> graph;
                for (const auto& time : times) {
                    graph[time[0]].emplace_back(time[1], time[2]);
                }
                priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
                pq.emplace(k, 0);
                vector<int> dist(n + 1, INT_MAX);
                dist[k] = 0;
                while (!pq.empty()) {
                    auto [node, time] = pq.top();
                    pq.pop();
                    if (time > dist[node]) continue;
                    for (const auto& edge : graph[node]) {
                        int neighbor = edge.first, newTime = time + edge.second;
                        if (newTime < dist[neighbor]) {
                            dist[neighbor] = newTime;
                            pq.emplace(neighbor, newTime);
                        }
                    }
                }
                int maxTime = 0;
                for (int i = 1; i <= n; ++i) {
                    if (dist[i] == INT_MAX) return -1;
                    maxTime = max(maxTime, dist[i]);
                }
                return maxTime;
            }
        """.trimIndent()
            ),
            Question(
                name = "Evaluate Division",
                link = "https://leetcode.com/problems/evaluate-division/",
                solutionJava = """
            public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
                Map<String, Map<String, Double>> graph = new HashMap<>();
                for (int i = 0; i < equations.size(); i++) {
                    String a = equations.get(i).get(0);
                    String b = equations.get(i).get(1);
                    graph.putIfAbsent(a, new HashMap<>());
                    graph.putIfAbsent(b, new HashMap<>());
                    graph.get(a).put(b, values[i]);
                    graph.get(b).put(a, 1.0 / values[i]);
                }
                double[] results = new double[queries.size()];
                for (int i = 0; i < queries.size(); i++) {
                    String a = queries.get(i).get(0);
                    String b = queries.get(i).get(1);
                    results[i] = dfs(graph, a, b, new HashSet<>());
                }
                return results;
            }
            private double dfs(Map<String, Map<String, Double>> graph, String a, String b, Set<String> visited) {
                if (!graph.containsKey(a) || !graph.containsKey(b)) return -1.0;
                if (a.equals(b)) return 1.0;
                visited.add(a);
                for (String neighbor : graph.get(a).keySet()) {
                    if (!visited.contains(neighbor)) {
                        double weight = graph.get(a).get(neighbor);
                        double result = dfs(graph, neighbor, b, visited);
                        if (result != -1.0) return weight * result;
                    }
                }
                return -1.0;
            }
        """.trimIndent(),
                solutionCpp = """
            vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
                unordered_map<string, unordered_map<string, double>> graph;
                for (int i = 0; i < equations.size(); i++) {
                    string a = equations[i][0], b = equations[i][1];
                    graph[a][b] = values[i];
                    graph[b][a] = 1.0 / values[i];
                }
                vector<double> results;
                for (const auto& query : queries) {
                    results.push_back(dfs(graph, query[0], query[1], unordered_set<string>()));
                }
                return results;
            }
            double dfs(const unordered_map<string, unordered_map<string, double>>& graph, const string& a, const string& b, unordered_set<string> visited) {
                if (!graph.count(a) || !graph.count(b)) return -1.0;
                if (a == b) return 1.0;
                visited.insert(a);
                for (const auto& neighbor : graph.at(a)) {
                    if (!visited.count(neighbor.first)) {
                        double weight = neighbor.second;
                        double result = dfs(graph, neighbor.first, b, visited);
                        if (result != -1.0) return weight * result;
                    }
                }
                return -1.0;
            }
        """.trimIndent()
            ),
            Question(
                name = "Redundant Connection",
                link = "https://leetcode.com/problems/redundant-connection/",
                solutionJava = """
            public int[] findRedundantConnection(int[][] edges) {
                int n = edges.length;
                UnionFind uf = new UnionFind(n);
                for (int[] edge : edges) {
                    if (!uf.union(edge[0] - 1, edge[1] - 1)) {
                        return edge;
                    }
                }
                return new int[0];
            }
            private class UnionFind {
                private int[] parent;
                public UnionFind(int size) {
                    parent = new int[size];
                    for (int i = 0; i < size; i++) parent[i] = i;
                }
                public int find(int x) {
                    if (parent[x] != x) {
                        parent[x] = find(parent[x]);
                    }
                    return parent[x];
                }
                public boolean union(int x, int y) {
                    int rootX = find(x);
                    int rootY = find(y);
                    if (rootX == rootY) return false;
                    parent[rootX] = rootY;
                    return true;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            vector<int> findRedundantConnection(vector<vector<int>>& edges) {
                int n = edges.size();
                UnionFind uf(n);
                for (const auto& edge : edges) {
                    if (!uf.union(edge[0], edge[1])) {
                        return edge;
                    }
                }
                return {};
            }
            class UnionFind {
                vector<int> parent;
            public:
                UnionFind(int size) : parent(size) {
                    for (int i = 0; i < size; i++) parent[i] = i;
                }
                int find(int x) {
                    if (parent[x] != x) {
                        parent[x] = find(parent[x]);
                    }
                    return parent[x];
                }
                bool union(int x, int y) {
                    int rootX = find(x);
                    int rootY = find(y);
                    if (rootX == rootY) return false;
                    parent[rootX] = rootY;
                    return true;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Is Graph Bipartite?",
                link = "https://leetcode.com/problems/is-graph-bipartite/",
                solutionJava = """
            public boolean isBipartite(int[][] graph) {
                int n = graph.length;
                int[] color = new int[n];
                Arrays.fill(color, -1);
                for (int i = 0; i < n; i++) {
                    if (color[i] == -1 && !dfs(graph, color, i, 0)) {
                        return false;
                    }
                }
                return true;
            }
            private boolean dfs(int[][] graph, int[] color, int node, int c) {
                color[node] = c;
                for (int neighbor : graph[node]) {
                    if (color[neighbor] == -1) {
                        if (!dfs(graph, color, neighbor, 1 - c)) {
                            return false;
                        }
                    } else if (color[neighbor] == c) {
                        return false;
                    }
                }
                return true;
            }
        """.trimIndent(),
                solutionCpp = """
            bool isBipartite(vector<vector<int>>& graph) {
                int n = graph.size();
                vector<int> color(n, -1);
                for (int i = 0; i < n; i++) {
                    if (color[i] == -1 && !dfs(graph, color, i, 0)) {
                        return false;
                    }
                }
                return true;
            }
            bool dfs(vector<vector<int>>& graph, vector<int>& color, int node, int c) {
                color[node] = c;
                for (int neighbor : graph[node]) {
                    if (color[neighbor] == -1) {
                        if (!dfs(graph, color, neighbor, 1 - c)) {
                            return false;
                        }
                    } else if (color[neighbor] == c) {
                        return false;
                    }
                }
                return true;
            }
        """.trimIndent()
            ),
            Question(
                name = "Cheapest Flights Within K Stops",
                link = "https://leetcode.com/problems/cheapest-flights-within-k-stops/",
                solutionJava = """
            public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
                Map<Integer, List<int[]>> graph = new HashMap<>();
                for (int[] flight : flights) {
                    graph.putIfAbsent(flight[0], new ArrayList<>());
                    graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
                }
                Queue<int[]> pq = new LinkedList<>();
                pq.offer(new int[]{src, 0, 0});
                int[] dist = new int[n];
                Arrays.fill(dist, Integer.MAX_VALUE);
                while (!pq.isEmpty()) {
                    int[] curr = pq.poll();
                    int node = curr[0], price = curr[1], stops = curr[2];
                    if (stops > k + 1) continue;
                    if (node == dst) return price;
                    for (int[] edge : graph.getOrDefault(node, new ArrayList<>())) {
                        int neighbor = edge[0], cost = edge[1];
                        if (price + cost < dist[neighbor]) {
                            dist[neighbor] = price + cost;
                            pq.offer(new int[]{neighbor, dist[neighbor], stops + 1});
                        }
                    }
                }
                return -1;
            }
        """.trimIndent(),
                solutionCpp = """
            int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
                unordered_map<int, vector<pair<int, int>>> graph;
                for (const auto& flight : flights) {
                    graph[flight[0]].emplace_back(flight[1], flight[2]);
                }
                queue<tuple<int, int, int>> pq; // node, price, stops
                pq.emplace(src, 0, 0);
                vector<int> dist(n, INT_MAX);
                while (!pq.empty()) {
                    auto [node, price, stops] = pq.front();
                    pq.pop();
                    if (stops > k + 1) continue;
                    if (node == dst) return price;
                    for (const auto& edge : graph[node]) {
                        int neighbor = edge.first, cost = edge.second;
                        if (price + cost < dist[neighbor]) {
                            dist[neighbor] = price + cost;
                            pq.emplace(neighbor, dist[neighbor], stops + 1);
                        }
                    }
                }
                return -1;
            }
        """.trimIndent()
            )
        ) // done
    ), Topic(
        topicName = "Dynamic Programming",
        topicDetails = "Problems solved using dynamic programming techniques",
        questions = listOf(
            Question(
                name = "Climbing Stairs",
                link = "https://leetcode.com/problems/climbing-stairs/",
                solutionJava = """
            class Solution {
                public int climbStairs(int n) {
                    if (n <= 2) return n;
                    int[] dp = new int[n + 1];
                    dp[1] = 1;
                    dp[2] = 2;
                    for (int i = 3; i <= n; i++) {
                        dp[i] = dp[i - 1] + dp[i - 2];
                    }
                    return dp[n];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int climbStairs(int n) {
                    if (n <= 2) return n;
                    vector<int> dp(n + 1);
                    dp[1] = 1;
                    dp[2] = 2;
                    for (int i = 3; i <= n; i++) {
                        dp[i] = dp[i - 1] + dp[i - 2];
                    }
                    return dp[n];
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Coin Change",
                link = "https://leetcode.com/problems/coin-change/",
                solutionJava = """
            class Solution {
                public int coinChange(int[] coins, int amount) {
                    int[] dp = new int[amount + 1];
                    Arrays.fill(dp, amount + 1);
                    dp[0] = 0;
                    for (int coin : coins) {
                        for (int j = coin; j <= amount; j++) {
                            dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                        }
                    }
                    return dp[amount] == amount + 1 ? -1 : dp[amount];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int coinChange(vector<int>& coins, int amount) {
                    vector<int> dp(amount + 1, amount + 1);
                    dp[0] = 0;
                    for (int coin : coins) {
                        for (int j = coin; j <= amount; j++) {
                            dp[j] = min(dp[j], dp[j - coin] + 1);
                        }
                    }
                    return dp[amount] == amount + 1 ? -1 : dp[amount];
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Longest Increasing Subsequence",
                link = "https://leetcode.com/problems/longest-increasing-subsequence/",
                solutionJava = """
            class Solution {
                public int lengthOfLIS(int[] nums) {
                    if (nums.length == 0) return 0;
                    int[] dp = new int[nums.length];
                    Arrays.fill(dp, 1);
                    for (int i = 1; i < nums.length; i++) {
                        for (int j = 0; j < i; j++) {
                            if (nums[i] > nums[j]) {
                                dp[i] = Math.max(dp[i], dp[j] + 1);
                            }
                        }
                    }
                    return Arrays.stream(dp).max().getAsInt();
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int lengthOfLIS(vector<int>& nums) {
                    if (nums.empty()) return 0;
                    vector<int> dp(nums.size(), 1);
                    for (int i = 1; i < nums.size(); i++) {
                        for (int j = 0; j < i; j++) {
                            if (nums[i] > nums[j]) {
                                dp[i] = max(dp[i], dp[j] + 1);
                            }
                        }
                    }
                    return *max_element(dp.begin(), dp.end());
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Word Break",
                link = "https://leetcode.com/problems/word-break/",
                solutionJava = """
            class Solution {
                public boolean wordBreak(String s, List<String> wordDict) {
                    Set<String> wordSet = new HashSet<>(wordDict);
                    boolean[] dp = new boolean[s.length() + 1];
                    dp[0] = true;
                    for (int i = 1; i <= s.length(); i++) {
                        for (int j = 0; j < i; j++) {
                            if (dp[j] && wordSet.contains(s.substring(j, i))) {
                                dp[i] = true;
                                break;
                            }
                        }
                    }
                    return dp[s.length()];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                bool wordBreak(string s, vector<string>& wordDict) {
                    unordered_set<string> wordSet(wordDict.begin(), wordDict.end());
                    vector<bool> dp(s.size() + 1, false);
                    dp[0] = true;
                    for (int i = 1; i <= s.size(); i++) {
                        for (int j = 0; j < i; j++) {
                            if (dp[j] && wordSet.count(s.substr(j, i - j))) {
                                dp[i] = true;
                                break;
                            }
                        }
                    }
                    return dp[s.size()];
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Combination Sum IV",
                link = "https://leetcode.com/problems/combination-sum-iv/",
                solutionJava = """
            class Solution {
                public int combinationSum4(int[] nums, int target) {
                    int[] dp = new int[target + 1];
                    dp[0] = 1;
                    for (int i = 1; i <= target; i++) {
                        for (int num : nums) {
                            if (i - num >= 0) {
                                dp[i] += dp[i - num];
                            }
                        }
                    }
                    return dp[target];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int combinationSum4(vector<int>& nums, int target) {
                    vector<int> dp(target + 1, 0);
                    dp[0] = 1;
                    for (int i = 1; i <= target; i++) {
                        for (int num : nums) {
                            if (i - num >= 0) {
                                dp[i] += dp[i - num];
                            }
                        }
                    }
                    return dp[target];
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "House Robber",
                link = "https://leetcode.com/problems/house-robber/",
                solutionJava = """
            class Solution {
                public int rob(int[] nums) {
                    if (nums.length == 0) return 0;
                    if (nums.length == 1) return nums[0];
                    int[] dp = new int[nums.length];
                    dp[0] = nums[0];
                    dp[1] = Math.max(nums[0], nums[1]);
                    for (int i = 2; i < nums.length; i++) {
                        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
                    }
                    return dp[nums.length - 1];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int rob(vector<int>& nums) {
                    if (nums.empty()) return 0;
                    if (nums.size() == 1) return nums[0];
                    vector<int> dp(nums.size());
                    dp[0] = nums[0];
                    dp[1] = max(nums[0], nums[1]);
                    for (int i = 2; i < nums.size(); i++) {
                        dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]);
                    }
                    return dp.back();
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Decode Ways",
                link = "https://leetcode.com/problems/decode-ways/",
                solutionJava = """
            class Solution {
                public int numDecodings(String s) {
                    if (s.length() == 0 || s.charAt(0) == '0') return 0;
                    int[] dp = new int[s.length() + 1];
                    dp[0] = 1;
                    dp[1] = 1;
                    for (int i = 2; i <= s.length(); i++) {
                        if (s.charAt(i - 1) != '0') {
                            dp[i] += dp[i - 1];
                        }
                        if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                            dp[i] += dp[i - 2];
                        }
                    }
                    return dp[s.length()];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int numDecodings(string s) {
                    if (s.empty() || s[0] == '0') return 0;
                    vector<int> dp(s.size() + 1);
                    dp[0] = 1;
                    dp[1] = 1;
                    for (int i = 2; i <= s.size(); i++) {
                        if (s[i - 1] != '0') {
                            dp[i] += dp[i - 1];
                        }
                        if (s[i - 2] == '1' || (s[i - 2] == '2' && s[i - 1] <= '6')) {
                            dp[i] += dp[i - 2];
                        }
                    }
                    return dp[s.size()];
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Unique Paths",
                link = "https://leetcode.com/problems/unique-paths/",
                solutionJava = """
            class Solution {
                public int uniquePaths(int m, int n) {
                    int[][] dp = new int[m][n];
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i == 0 || j == 0) {
                                dp[i][j] = 1;
                            } else {
                                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                            }
                        }
                    }
                    return dp[m - 1][n - 1];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int uniquePaths(int m, int n) {
                    vector<vector<int>> dp(m, vector<int>(n, 1));
                    for (int i = 1; i < m; i++) {
                        for (int j = 1; j < n; j++) {
                            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                        }
                    }
                    return dp[m - 1][n - 1];
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Jump Game",
                link = "https://leetcode.com/problems/jump-game/",
                solutionJava = """
            class Solution {
                public boolean canJump(int[] nums) {
                    int reachable = 0;
                    for (int i = 0; i < nums.length; i++) {
                        if (i > reachable) return false;
                        reachable = Math.max(reachable, i + nums[i]);
                    }
                    return true;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                bool canJump(vector<int>& nums) {
                    int reachable = 0;
                    for (int i = 0; i < nums.size(); i++) {
                        if (i > reachable) return false;
                        reachable = max(reachable, i + nums[i]);
                    }
                    return true;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Palindromic Substrings",
                link = "https://leetcode.com/problems/palindromic-substrings/",
                solutionJava = """
            class Solution {
                public int countSubstrings(String s) {
                    int n = s.length(), count = 0;
                    boolean[][] dp = new boolean[n][n];
                    for (int i = 0; i < n; i++) {
                        dp[i][i] = true;
                        count++;
                    }
                    for (int i = 0; i < n - 1; i++) {
                        if (s.charAt(i) == s.charAt(i + 1)) {
                            dp[i][i + 1] = true;
                            count++;
                        }
                    }
                    for (int length = 3; length <= n; length++) {
                        for (int i = 0; i < n - length + 1; i++) {
                            int j = i + length - 1;
                            if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                                dp[i][j] = true;
                                count++;
                            }
                        }
                    }
                    return count;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int countSubstrings(string s) {
                    int n = s.size(), count = 0;
                    vector<vector<bool>> dp(n, vector<bool>(n, false));
                    for (int i = 0; i < n; i++) {
                        dp[i][i] = true;
                        count++;
                    }
                    for (int i = 0; i < n - 1; i++) {
                        if (s[i] == s[i + 1]) {
                            dp[i][i + 1] = true;
                            count++;
                        }
                    }
                    for (int length = 3; length <= n; length++) {
                        for (int i = 0; i < n - length + 1; i++) {
                            int j = i + length - 1;
                            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                                dp[i][j] = true;
                                count++;
                            }
                        }
                    }
                    return count;
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Longest Palindromic Subsequence",
                link = "https://leetcode.com/problems/longest-palindromic-subsequence/",
                solutionJava = """
            class Solution {
                public int longestPalindromeSubseq(String s) {
                    int n = s.length();
                    int[][] dp = new int[n][n];
                    for (int i = 0; i < n; i++) {
                        dp[i][i] = 1;
                    }
                    for (int length = 2; length <= n; length++) {
                        for (int i = 0; i < n - length + 1; i++) {
                            int j = i + length - 1;
                            if (s.charAt(i) == s.charAt(j)) {
                                dp[i][j] = dp[i + 1][j - 1] + 2;
                            } else {
                                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                            }
                        }
                    }
                    return dp[0][n - 1];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int longestPalindromeSubseq(string s) {
                    int n = s.size();
                    vector<vector<int>> dp(n, vector<int>(n, 0));
                    for (int i = 0; i < n; i++) {
                        dp[i][i] = 1;
                    }
                    for (int length = 2; length <= n; length++) {
                        for (int i = 0; i < n - length + 1; i++) {
                            int j = i + length - 1;
                            if (s[i] == s[j]) {
                                dp[i][j] = dp[i + 1][j - 1] + 2;
                            } else {
                                dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
                            }
                        }
                    }
                    return dp[0][n - 1];
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Edit Distance",
                link = "https://leetcode.com/problems/edit-distance/",
                solutionJava = """
            class Solution {
                public int minDistance(String word1, String word2) {
                    int m = word1.length(), n = word2.length();
                    int[][] dp = new int[m + 1][n + 1];
                    for (int i = 0; i <= m; i++) {
                        for (int j = 0; j <= n; j++) {
                            if (i == 0) {
                                dp[i][j] = j; // if word1 is empty
                            } else if (j == 0) {
                                dp[i][j] = i; // if word2 is empty
                            } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                                dp[i][j] = dp[i - 1][j - 1];
                            } else {
                                dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                            }
                        }
                    }
                    return dp[m][n];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int minDistance(string word1, string word2) {
                    int m = word1.size(), n = word2.size();
                    vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
                    for (int i = 0; i <= m; i++) {
                        for (int j = 0; j <= n; j++) {
                            if (i == 0) {
                                dp[i][j] = j; // if word1 is empty
                            } else if (j == 0) {
                                dp[i][j] = i; // if word2 is empty
                            } else if (word1[i - 1] == word2[j - 1]) {
                                dp[i][j] = dp[i - 1][j - 1];
                            } else {
                                dp[i][j] = 1 + min({dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]});
                            }
                        }
                    }
                    return dp[m][n];
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Burst Balloons",
                link = "https://leetcode.com/problems/burst-balloons/",
                solutionJava = """
            class Solution {
                public int maxCoins(int[] nums) {
                    int n = nums.length;
                    int[] balloons = new int[n + 2];
                    balloons[0] = 1;
                    balloons[n + 1] = 1;
                    for (int i = 1; i <= n; i++) {
                        balloons[i] = nums[i - 1];
                    }
                    int[][] dp = new int[n + 2][n + 2];
                    for (int len = 1; len <= n; len++) {
                        for (int left = 1; left <= n - len + 1; left++) {
                            int right = left + len - 1;
                            for (int i = left; i <= right; i++) {
                                dp[left][right] = Math.max(dp[left][right], balloons[left - 1] * balloons[i] * balloons[right + 1] + dp[left][i - 1] + dp[i + 1][right]);
                            }
                        }
                    }
                    return dp[1][n];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int maxCoins(vector<int>& nums) {
                    int n = nums.size();
                    vector<int> balloons(n + 2, 1);
                    for (int i = 1; i <= n; i++) {
                        balloons[i] = nums[i - 1];
                    }
                    vector<vector<int>> dp(n + 2, vector<int>(n + 2, 0));
                    for (int len = 1; len <= n; len++) {
                        for (int left = 1; left <= n - len + 1; left++) {
                            int right = left + len - 1;
                            for (int i = left; i <= right; i++) {
                                dp[left][right] = max(dp[left][right], balloons[left - 1] * balloons[i] * balloons[right + 1] + dp[left][i - 1] + dp[i + 1][right]);
                            }
                        }
                    }
                    return dp[1][n];
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Regular Expression Matching",
                link = "https://leetcode.com/problems/regular-expression-matching/",
                solutionJava = """
            class Solution {
                public boolean isMatch(String s, String p) {
                    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
                    dp[0][0] = true;
                    for (int j = 1; j <= p.length(); j++) {
                        if (p.charAt(j - 1) == '*') {
                            dp[0][j] = dp[0][j - 2];
                        }
                    }
                    for (int i = 1; i <= s.length(); i++) {
                        for (int j = 1; j <= p.length(); j++) {
                            if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                                dp[i][j] = dp[i - 1][j - 1];
                            } else if (p.charAt(j - 1) == '*') {
                                dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                            }
                        }
                    }
                    return dp[s.length()][p.length()];
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                bool isMatch(string s, string p) {
                    vector<vector<bool>> dp(s.size() + 1, vector<bool>(p.size() + 1, false));
                    dp[0][0] = true;
                    for (int j = 1; j <= p.size(); j++) {
                        if (p[j - 1] == '*') {
                            dp[0][j] = dp[0][j - 2];
                        }
                    }
                    for (int i = 1; i <= s.size(); i++) {
                        for (int j = 1; j <= p.size(); j++) {
                            if (p[j - 1] == s[i - 1] || p[j - 1] == '.') {
                                dp[i][j] = dp[i - 1][j - 1];
                            } else if (p[j - 1] == '*') {
                                dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.'));
                            }
                        }
                    }
                    return dp[s.size()][p.size()];
                }
            };
        """.trimIndent()
            ),
            Question(
                name = "Maximal Rectangle",
                link = "https://leetcode.com/problems/maximal-rectangle/",
                solutionJava = """
            class Solution {
                public int maximalRectangle(char[][] matrix) {
                    if (matrix.length == 0) return 0;
                    int maxArea = 0, n = matrix.length, m = matrix[0].length;
                    int[] heights = new int[m];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
                        }
                        maxArea = Math.max(maxArea, maxHist(heights));
                    }
                    return maxArea;
                }
                
                private int maxHist(int[] heights) {
                    Stack<Integer> stack = new Stack<>();
                    int maxArea = 0, area = 0, i = 0;
                    while (i < heights.length) {
                        if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                            stack.push(i++);
                        } else {
                            int top = stack.pop();
                            area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                    while (!stack.isEmpty()) {
                        int top = stack.pop();
                        area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                        maxArea = Math.max(maxArea, area);
                    }
                    return maxArea;
                }
            }
        """.trimIndent(),
                solutionCpp = """
            class Solution {
            public:
                int maximalRectangle(vector<vector<char>>& matrix) {
                    if (matrix.empty()) return 0;
                    int maxArea = 0, n = matrix.size(), m = matrix[0].size();
                    vector<int> heights(m, 0);
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
                        }
                        maxArea = max(maxArea, maxHist(heights));
                    }
                    return maxArea;
                }

                int maxHist(vector<int>& heights) {
                    stack<int> stack;
                    int maxArea = 0, area = 0, i = 0;
                    while (i < heights.size()) {
                        if (stack.empty() || heights[stack.top()] <= heights[i]) {
                            stack.push(i++);
                        } else {
                            int top = stack.top();
                            stack.pop();
                            area = heights[top] * (stack.empty() ? i : i - stack.top() - 1);
                            maxArea = max(maxArea, area);
                        }
                    }
                    while (!stack.empty()) {
                        int top = stack.top();
                        stack.pop();
                        area = heights[top] * (stack.empty() ? i : i - stack.top() - 1);
                        maxArea = max(maxArea, area);
                    }
                    return maxArea;
                }
            };
        """.trimIndent()
            )
        ) // done
    ), Topic(
        topicName = "Tries",
        topicDetails = "Advanced tree-like data structure for efficient string operations",
        questions = listOf(
            Question(
                name = "Implement Trie (Prefix Tree)",
                link = "https://leetcode.com/problems/implement-trie-prefix-tree/",
                solutionJava = """
            class Trie {
                private final TrieNode root;
                public Trie() {
                    root = new TrieNode();
                }
                public void insert(String word) {
                    TrieNode node = root;
                    for (char c : word.toCharArray()) {
                        node = node.children.computeIfAbsent(c, k -> new TrieNode());
                    }
                    node.isEnd = true;
                }
                public boolean search(String word) {
                    TrieNode node = root;
                    for (char c : word.toCharArray()) {
                        node = node.children.get(c);
                        if (node == null) return false;
                    }
                    return node.isEnd;
                }
                public boolean startsWith(String prefix) {
                    TrieNode node = root;
                    for (char c : prefix.toCharArray()) {
                        node = node.children.get(c);
                        if (node == null) return false;
                    }
                    return true;
                }
            }
            class TrieNode {
                Map<Character, TrieNode> children = new HashMap<>();
                boolean isEnd = false;
            }
        """,
                solutionCpp = """
            class TrieNode {
                public:
                    map<char, TrieNode*> children;
                    bool isEnd = false;
            };
            class Trie {
                TrieNode* root;
            public:
                Trie() {
                    root = new TrieNode();
                }
                void insert(string word) {
                    TrieNode* node = root;
                    for (char c : word) {
                        if (!node->children.count(c)) {
                            node->children[c] = new TrieNode();
                        }
                        node = node->children[c];
                    }
                    node->isEnd = true;
                }
                bool search(string word) {
                    TrieNode* node = root;
                    for (char c : word) {
                        if (!node->children.count(c)) return false;
                        node = node->children[c];
                    }
                    return node->isEnd;
                }
                bool startsWith(string prefix) {
                    TrieNode* node = root;
                    for (char c : prefix) {
                        if (!node->children.count(c)) return false;
                        node = node->children[c];
                    }
                    return true;
                }
            };
        """
            ),
            Question(
                name = "Design Add and Search Words Data Structure",
                link = "https://leetcode.com/problems/design-add-and-search-words-data-structure/",
                solutionJava = """
            class WordDictionary {
                private class TrieNode {
                    Map<Character, TrieNode> children = new HashMap<>();
                    boolean isEnd = false;
                }
                private TrieNode root;
                public WordDictionary() {
                    root = new TrieNode();
                }
                public void addWord(String word) {
                    TrieNode node = root;
                    for (char c : word.toCharArray()) {
                        node = node.children.computeIfAbsent(c, k -> new TrieNode());
                    }
                    node.isEnd = true;
                }
                public boolean search(String word) {
                    return searchInNode(word, root);
                }
                private boolean searchInNode(String word, TrieNode node) {
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                        if (c != '.') {
                            if (!node.children.containsKey(c)) return false;
                            node = node.children.get(c);
                        } else {
                            for (TrieNode child : node.children.values()) {
                                if (searchInNode(word.substring(i + 1), child)) return true;
                            }
                            return false;
                        }
                    }
                    return node.isEnd;
                }
            }
        """,
                solutionCpp = """
            class WordDictionary {
                struct TrieNode {
                    map<char, TrieNode*> children;
                    bool isEnd = false;
                };
                TrieNode* root;
            public:
                WordDictionary() {
                    root = new TrieNode();
                }
                void addWord(string word) {
                    TrieNode* node = root;
                    for (char c : word) {
                        if (!node->children.count(c)) {
                            node->children[c] = new TrieNode();
                        }
                        node = node->children[c];
                    }
                    node->isEnd = true;
                }
                bool search(string word) {
                    return searchInNode(word, root);
                }
                bool searchInNode(string word, TrieNode* node) {
                    for (int i = 0; i < word.size(); i++) {
                        char c = word[i];
                        if (c != '.') {
                            if (!node->children.count(c)) return false;
                            node = node->children[c];
                        } else {
                            for (auto& child : node->children) {
                                if (searchInNode(word.substr(i + 1), child.second)) return true;
                            }
                            return false;
                        }
                    }
                    return node->isEnd;
                }
            };
        """
            ),
            Question(
                name = "Word Search II",
                link = "https://leetcode.com/problems/word-search-ii/",
                solutionJava = """
            class Solution {
                public List<String> findWords(char[][] board, String[] words) {
                    Set<String> result = new HashSet<>();
                    Trie trie = new Trie();
                    for (String word : words) {
                        trie.insert(word);
                    }
                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[0].length; j++) {
                            dfs(board, i, j, trie.root, "", result);
                        }
                    }
                    return new ArrayList<>(result);
                }
                private void dfs(char[][] board, int i, int j, TrieNode node, String path, Set<String> result) {
                    if (node.isEnd) {
                        result.add(path);
                        node.isEnd = false; // Avoid duplicates
                    }
                    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') {
                        return;
                    }
                    char temp = board[i][j];
                    node = node.children.get(temp);
                    if (node == null) return;
                    board[i][j] = '#'; // Mark as visited
                    dfs(board, i + 1, j, node, path + temp, result);
                    dfs(board, i - 1, j, node, path + temp, result);
                    dfs(board, i, j + 1, node, path + temp, result);
                    dfs(board, i, j - 1, node, path + temp, result);
                    board[i][j] = temp; // Restore the state
                }
            }
            class Trie {
                TrieNode root = new TrieNode();
                void insert(String word) {
                    TrieNode node = root;
                    for (char c : word.toCharArray()) {
                        node = node.children.computeIfAbsent(c, k -> new TrieNode());
                    }
                    node.isEnd = true;
                }
            }
            class TrieNode {
                Map<Character, TrieNode> children = new HashMap<>();
                boolean isEnd = false;
            }
        """,
                solutionCpp = """
            class Solution {
                public:
                    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
                        unordered_set<string> result;
                        Trie trie;
                        for (const string& word : words) {
                            trie.insert(word);
                        }
                        for (int i = 0; i < board.size(); i++) {
                            for (int j = 0; j < board[0].size(); j++) {
                                dfs(board, i, j, trie.root, "", result);
                            }
                        }
                        return vector<string>(result.begin(), result.end());
                    }
                    void dfs(vector<vector<char>>& board, int i, int j, TrieNode* node, string path, unordered_set<string>& result) {
                        if (node->isEnd) {
                            result.insert(path);
                            node->isEnd = false; // Avoid duplicates
                        }
                        if (i < 0 || j < 0 || i >= board.size() || j >= board[0].size() || board[i][j] == '#') {
                            return;
                        }
                        char temp = board[i][j];
                        node = node->children.count(temp) ? node->children[temp] : nullptr;
                        if (!node) return;
                        board[i][j] = '#'; // Mark as visited
                        dfs(board, i + 1, j, node, path + temp, result);
                        dfs(board, i - 1, j, node, path + temp, result);
                        dfs(board, i, j + 1, node, path + temp, result);
                        dfs(board, i, j - 1, node, path + temp, result);
                        board[i][j] = temp; // Restore the state
                    }
            };
            class TrieNode {
                public:
                    map<char, TrieNode*> children;
                    bool isEnd = false;
            };
            class Trie {
                TrieNode* root;
            public:
                Trie() {
                    root = new TrieNode();
                }
                void insert(string word) {
                    TrieNode* node = root;
                    for (char c : word) {
                        if (!node->children.count(c)) {
                            node->children[c] = new TrieNode();
                        }
                        node = node->children[c];
                    }
                    node->isEnd = true;
                }
            };
        """
            ),
            Question(
                name = "Replace Words",
                link = "https://leetcode.com/problems/replace-words/",
                solutionJava = """
            class Solution {
                public String replaceWords(List<String> dict, String sentence) {
                    Trie trie = new Trie();
                    for (String root : dict) {
                        trie.insert(root);
                    }
                    StringBuilder result = new StringBuilder();
                    for (String word : sentence.split(" ")) {
                        String root = trie.findRoot(word);
                        result.append(root).append(" ");
                    }
                    return result.toString().trim();
                }
            }
            class Trie {
                private TrieNode root;
                public Trie() {
                    root = new TrieNode();
                }
                public void insert(String word) {
                    TrieNode node = root;
                    for (char c : word.toCharArray()) {
                        node = node.children.computeIfAbsent(c, k -> new TrieNode());
                    }
                    node.isEnd = true;
                }
                public String findRoot(String word) {
                    TrieNode node = root;
                    StringBuilder root = new StringBuilder();
                    for (char c : word.toCharArray()) {
                        if (node.isEnd) break;
                        if (!node.children.containsKey(c)) return word;
                        root.append(c);
                        node = node.children.get(c);
                    }
                    return node.isEnd ? root.toString() : word;
                }
            }
            class TrieNode {
                Map<Character, TrieNode> children = new HashMap<>();
                boolean isEnd = false;
            }
        """,
                solutionCpp = """
            class Solution {
                public:
                    string replaceWords(vector<string>& dict, string sentence) {
                        Trie trie;
                        for (const string& root : dict) {
                            trie.insert(root);
                        }
                        string result;
                        istringstream iss(sentence);
                        string word;
                        while (iss >> word) {
                            string root = trie.findRoot(word);
                            result += root + " ";
                        }
                        return result.substr(0, result.size() - 1); // Remove trailing space
                    }
            };
            class Trie {
                TrieNode* root;
            public:
                Trie() {
                    root = new TrieNode();
                }
                void insert(string word) {
                    TrieNode* node = root;
                    for (char c : word) {
                        if (!node->children.count(c)) {
                            node->children[c] = new TrieNode();
                        }
                        node = node->children[c];
                    }
                    node->isEnd = true;
                }
                string findRoot(string word) {
                    TrieNode* node = root;
                    string root;
                    for (char c : word) {
                        if (node->isEnd) break;
                        if (!node->children.count(c)) return word;
                        root += c;
                        node = node->children[c];
                    }
                    return node->isEnd ? root : word;
                }
            };
            class TrieNode {
                public:
                    map<char, TrieNode*> children;
                    bool isEnd = false;
            };
        """
            ),
            Question(
                name = "Maximum XOR of Two Numbers in an Array",
                link = "https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/",
                solutionJava = """
            class Solution {
                public int findMaximumXOR(int[] nums) {
                    Trie trie = new Trie();
                    for (int num : nums) {
                        trie.insert(num);
                    }
                    int maxXOR = 0;
                    for (int num : nums) {
                        maxXOR = Math.max(maxXOR, trie.getMaxXOR(num));
                    }
                    return maxXOR;
                }
            }
            class Trie {
                private TrieNode root;
                public Trie() {
                    root = new TrieNode();
                }
                public void insert(int num) {
                    TrieNode node = root;
                    for (int i = 31; i >= 0; i--) {
                        int bit = (num >> i) & 1;
                        if (bit == 0) {
                            if (node.children[1] == null) node.children[1] = new TrieNode();
                            node = node.children[1];
                        } else {
                            if (node.children[0] == null) node.children[0] = new TrieNode();
                            node = node.children[0];
                        }
                    }
                }
                public int getMaxXOR(int num) {
                    TrieNode node = root;
                    int maxXOR = 0;
                    for (int i = 31; i >= 0; i--) {
                        int bit = (num >> i) & 1;
                        if (bit == 0) {
                            if (node.children[1] != null) {
                                maxXOR |= (1 << i);
                                node = node.children[1];
                            } else {
                                node = node.children[0];
                            }
                        } else {
                            if (node.children[0] != null) {
                                maxXOR |= (1 << i);
                                node = node.children[0];
                            } else {
                                node = node.children[1];
                            }
                        }
                    }
                    return maxXOR;
                }
            }
            class TrieNode {
                TrieNode[] children = new TrieNode[2];
            }
        """,
                solutionCpp = """
            class Solution {
                public:
                    int findMaximumXOR(vector<int>& nums) {
                        Trie trie;
                        for (int num : nums) {
                            trie.insert(num);
                        }
                        int maxXOR = 0;
                        for (int num : nums) {
                            maxXOR = max(maxXOR, trie.getMaxXOR(num));
                        }
                        return maxXOR;
                    }
            };
            class Trie {
                TrieNode* root;
            public:
                Trie() {
                    root = new TrieNode();
                }
                void insert(int num) {
                    TrieNode* node = root;
                    for (int i = 31; i >= 0; i--) {
                        int bit = (num >> i) & 1;
                        if (bit == 0) {
                            if (!node->children.count(1)) node->children[1] = new TrieNode();
                            node = node->children[1];
                        } else {
                            if (!node->children.count(0)) node->children[0] = new TrieNode();
                            node = node->children[0];
                        }
                    }
                }
                int getMaxXOR(int num) {
                    TrieNode* node = root;
                    int maxXOR = 0;
                    for (int i = 31; i >= 0; i--) {
                        int bit = (num >> i) & 1;
                        if (bit == 0) {
                            if (node->children.count(1)) {
                                maxXOR |= (1 << i);
                                node = node->children[1];
                            } else {
                                node = node->children[0];
                            }
                        } else {
                            if (node->children.count(0)) {
                                maxXOR |= (1 << i);
                                node = node->children[0];
                            } else {
                                node = node->children[1];
                            }
                        }
                    }
                    return maxXOR;
                }
            };
            class TrieNode {
                public:
                    map<int, TrieNode*> children;
            };
        """
            ),
            Question(
                name = "Map Sum Pairs",
                link = "https://leetcode.com/problems/map-sum-pairs/",
                solutionJava = """
            class MapSum {
                private class TrieNode {
                    Map<Character, TrieNode> children = new HashMap<>();
                    int value = 0;
                }
                private TrieNode root;
                private Map<String, Integer> map;
                public MapSum() {
                    root = new TrieNode();
                    map = new HashMap<>();
                }
                public void insert(String key, int val) {
                    int delta = val - map.getOrDefault(key, 0);
                    map.put(key, val);
                    TrieNode node = root;
                    for (char c : key.toCharArray()) {
                        node = node.children.computeIfAbsent(c, k -> new TrieNode());
                        node.value += delta;
                    }
                }
                public int sum(String prefix) {
                    TrieNode node = root;
                    for (char c : prefix.toCharArray()) {
                        node = node.children.get(c);
                        if (node == null) return 0;
                    }
                    return node.value;
                }
            }
        """,
                solutionCpp = """
            class MapSum {
                struct TrieNode {
                    map<char, TrieNode*> children;
                    int value = 0;
                };
                TrieNode* root;
                unordered_map<string, int> map;
            public:
                MapSum() {
                    root = new TrieNode();
                }
                void insert(string key, int val) {
                    int delta = val - map[key];
                    map[key] = val;
                    TrieNode* node = root;
                    for (char c : key) {
                        node = node->children[c] = node->children.count(c) ? node->children[c] : new TrieNode();
                        node->value += delta;
                    }
                }
                int sum(string prefix) {
                    TrieNode* node = root;
                    for (char c : prefix) {
                        if (!node->children.count(c)) return 0;
                        node = node->children[c];
                    }
                    return node->value;
                }
            };
        """
            ),
            Question(
                name = "Implement Magic Dictionary",
                link = "https://leetcode.com/problems/implement-magic-dictionary/",
                solutionJava = """
            class MagicDictionary {
                private Trie trie;
                public MagicDictionary() {
                    trie = new Trie();
                }
                public void buildDict(String[] dictionary) {
                    for (String word : dictionary) {
                        trie.insert(word);
                    }
                }
                public boolean search(String searchWord) {
                    return trie.search(searchWord, 0, false);
                }
            }
            class Trie {
                private TrieNode root;
                public Trie() {
                    root = new TrieNode();
                }
                public void insert(String word) {
                    TrieNode node = root;
                    for (char c : word.toCharArray()) {
                        node = node.children.computeIfAbsent(c, k -> new TrieNode());
                    }
                    node.isEnd = true;
                }
                public boolean search(String word, int index, boolean modified) {
                    if (index == word.length()) return modified && root.isEnd;
                    char c = word.charAt(index);
                    for (char key : root.children.keySet()) {
                        if (key == c) {
                            if (search(root.children.get(key), word, index + 1, modified)) return true;
                        } else {
                            if (!modified && search(root.children.get(key), word, index + 1, true)) return true;
                        }
                    }
                    return false;
                }
            }
            class TrieNode {
                Map<Character, TrieNode> children = new HashMap<>();
                boolean isEnd = false;
            }
        """,
                solutionCpp = """
            class MagicDictionary {
                Trie trie;
            public:
                MagicDictionary() {}
                void buildDict(vector<string> dictionary) {
                    for (const string& word : dictionary) {
                        trie.insert(word);
                    }
                }
                bool search(string searchWord) {
                    return trie.search(searchWord, 0, false);
                }
            };
            class Trie {
                TrieNode* root;
            public:
                Trie() {
                    root = new TrieNode();
                }
                void insert(string word) {
                    TrieNode* node = root;
                    for (char c : word) {
                        node = node->children[c] = node->children.count(c) ? node->children[c] : new TrieNode();
                    }
                    node->isEnd = true;
                }
                bool search(string word, int index, bool modified) {
                    if (index == word.size()) return modified && root->isEnd;
                    char c = word[index];
                    for (auto& [key, child] : root->children) {
                        if (key == c) {
                            if (child->search(word, index + 1, modified)) return true;
                        } else {
                            if (!modified && child->search(word, index + 1, true)) return true;
                        }
                    }
                    return false;
                }
            };
            class TrieNode {
                public:
                    unordered_map<char, TrieNode*> children;
                    bool isEnd = false;
            };
        """
            ),
            Question(
                name = "Palindrome Pairs",
                link = "https://leetcode.com/problems/palindrome-pairs/",
                solutionJava = """
            class Solution {
                public List<List<Integer>> palindromePairs(String[] words) {
                    List<List<Integer>> result = new ArrayList<>();
                    Trie trie = new Trie();
                    for (int i = 0; i < words.length; i++) {
                        trie.insert(words[i], i);
                    }
                    for (int i = 0; i < words.length; i++) {
                        for (int j = 0; j <= words[i].length(); j++) {
                            String prefix = words[i].substring(0, j);
                            String suffix = words[i].substring(j);
                            if (trie.search(prefix, suffix)) {
                                result.add(Arrays.asList(i, trie.search(prefix, suffix)));
                            }
                        }
                    }
                    return result;
                }
            }
            class Trie {
                private TrieNode root;
                public Trie() {
                    root = new TrieNode();
                }
                public void insert(String word, int index) {
                    TrieNode node = root;
                    for (int i = word.length() - 1; i >= 0; i--) {
                        char c = word.charAt(i);
                        node = node.children.computeIfAbsent(c, k -> new TrieNode());
                        node.indices.add(index);
                    }
                    node.isEnd = true;
                }
                public int search(String prefix, String suffix) {
                    TrieNode node = root;
                    for (char c : prefix.toCharArray()) {
                        if (!node.children.containsKey(c)) return -1;
                        node = node.children.get(c);
                    }
                    if (node.isEnd) return -1;
                    for (int index : node.indices) {
                        if (isPalindrome(suffix)) return index;
                    }
                    return -1;
                }
                private boolean isPalindrome(String word) {
                    int left = 0, right = word.length() - 1;
                    while (left < right) {
                        if (word.charAt(left++) != word.charAt(right--)) return false;
                    }
                    return true;
                }
            }
            class TrieNode {
                Map<Character, TrieNode> children = new HashMap<>();
                List<Integer> indices = new ArrayList<>();
                boolean isEnd = false;
            }
        """,
                solutionCpp = """
            class Solution {
                public:
                    vector<vector<int>> palindromePairs(vector<string>& words) {
                        vector<vector<int>> result;
                        Trie trie;
                        for (int i = 0; i < words.size(); i++) {
                            trie.insert(words[i], i);
                        }
                        for (int i = 0; i < words.size(); i++) {
                            for (int j = 0; j <= words[i].size(); j++) {
                                string prefix = words[i].substr(0, j);
                                string suffix = words[i].substr(j);
                                if (trie.search(prefix, suffix)) {
                                    result.push_back({i, trie.search(prefix, suffix)});
                                }
                            }
                        }
                        return result;
                    }
            };
            class Trie {
                TrieNode* root;
            public:
                Trie() {
                    root = new TrieNode();
                }
                void insert(string word, int index) {
                    TrieNode* node = root;
                    for (int i = word.size() - 1; i >= 0; i--) {
                        char c = word[i];
                        node = node->children[c] = node->children.count(c) ? node->children[c] : new TrieNode();
                        node->indices.push_back(index);
                    }
                    node->isEnd = true;
                }
                int search(string prefix, string suffix) {
                    TrieNode* node = root;
                    for (char c : prefix) {
                        if (!node->children.count(c)) return -1;
                        node = node->children[c];
                    }
                    if (node->isEnd) return -1;
                    for (int index : node->indices) {
                        if (isPalindrome(suffix)) return index;
                    }
                    return -1;
                }
                bool isPalindrome(const string& word) {
                    int left = 0, right = word.size() - 1;
                    while (left < right) {
                        if (word[left++] != word[right--]) return false;
                    }
                    return true;
                }
            };
            class TrieNode {
                public:
                    unordered_map<char, TrieNode*> children;
                    vector<int> indices;
                    bool isEnd = false;
            };
        """
            ),
            Question(
                name = "Design Search Autocomplete System",
                link = "https://leetcode.com/problems/design-search-autocomplete-system/",
                solutionJava = """
            class AutocompleteSystem {
                private class TrieNode {
                    Map<Character, TrieNode> children = new HashMap<>();
                    List<String> sentences = new ArrayList<>();
                    List<Integer> times = new ArrayList<>();
                }
                private TrieNode root;
                private StringBuilder input;
                public AutocompleteSystem(String[] sentences, int[] times) {
                    root = new TrieNode();
                    input = new StringBuilder();
                    for (int i = 0; i < sentences.length; i++) {
                        insert(sentences[i], times[i]);
                    }
                }
                public void insert(String sentence, int time) {
                    TrieNode node = root;
                    for (char c : sentence.toCharArray()) {
                        node = node.children.computeIfAbsent(c, k -> new TrieNode());
                    }
                    node.sentences.add(sentence);
                    node.times.add(time);
                }
                public List<String> input(char c) {
                    if (c == '#') {
                        insert(input.toString(), 1);
                        input.setLength(0);
                        return new ArrayList<>();
                    }
                    input.append(c);
                    return getSuggestions();
                }
                private List<String> getSuggestions() {
                    TrieNode node = root;
                    for (char c : input.toString().toCharArray()) {
                        if (node.children.containsKey(c)) {
                            node = node.children.get(c);
                        } else {
                            return new ArrayList<>();
                        }
                    }
                    List<String> result = new ArrayList<>();
                    PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
                        if (a.getValue() != b.getValue()) return b.getValue() - a.getValue();
                        return a.getKey().compareTo(b.getKey());
                    });
                    for (int i = 0; i < node.sentences.size(); i++) {
                        pq.offer(new Pair<>(node.sentences.get(i), node.times.get(i)));
                    }
                    while (!pq.isEmpty() && result.size() < 3) {
                        result.add(pq.poll().getKey());
                    }
                    return result;
                }
            }
        """,
                solutionCpp = """
            class AutocompleteSystem {
                struct TrieNode {
                    map<char, TrieNode*> children;
                    vector<string> sentences;
                    vector<int> times;
                };
                TrieNode* root;
                string input;
            public:
                AutocompleteSystem(vector<string> sentences, vector<int> times) {
                    root = new TrieNode();
                    input = "";
                    for (int i = 0; i < sentences.size(); i++) {
                        insert(sentences[i], times[i]);
                    }
                }
                void insert(string sentence, int time) {
                    TrieNode* node = root;
                    for (char c : sentence) {
                        if (!node->children.count(c)) {
                            node->children[c] = new TrieNode();
                        }
                        node = node->children[c];
                    }
                    node->sentences.push_back(sentence);
                    node->times.push_back(time);
                }
                vector<string> input(char c) {
                    if (c == '#') {
                        insert(input, 1);
                        input = "";
                        return {};
                    }
                    input += c;
                    return getSuggestions();
                }
                vector<string> getSuggestions() {
                    TrieNode* node = root;
                    for (char c : input) {
                        if (!node->children.count(c)) {
                            return {};
                        }
                        node = node->children[c];
                    }
                    priority_queue<pair<int, string>> pq;
                    for (int i = 0; i < node->sentences.size(); i++) {
                        pq.push({node->times[i], node->sentences[i]});
                    }
                    vector<string> result;
                    while (!pq.empty() && result.size() < 3) {
                        result.push_back(pq.top().second);
                        pq.pop();
                    }
                    return result;
                }
            };
        """
            ),
            Question(
                name = "Stream of Characters",
                link = "https://leetcode.com/problems/stream-of-characters/",
                solutionJava = """
            class StreamChecker {
                private class TrieNode {
                    Map<Character, TrieNode> children = new HashMap<>();
                    boolean isEnd = false;
                }
                private TrieNode root;
                private StringBuilder stream;
                public StreamChecker(String[] words) {
                    root = new TrieNode();
                    stream = new StringBuilder();
                    for (String word : words) {
                        insert(word);
                    }
                }
                public void insert(String word) {
                    TrieNode node = root;
                    for (int i = word.length() - 1; i >= 0; i--) {
                        char c = word.charAt(i);
                        node = node.children.computeIfAbsent(c, k -> new TrieNode());
                    }
                    node.isEnd = true;
                }
                public boolean query(char letter) {
                    stream.append(letter);
                    TrieNode node = root;
                    for (int i = stream.length() - 1; i >= 0; i--) {
                        char c = stream.charAt(i);
                        node = node.children.get(c);
                        if (node == null) return false;
                        if (node.isEnd) return true;
                    }
                    return false;
                }
            }
        """,
                solutionCpp = """
            class StreamChecker {
                struct TrieNode {
                    unordered_map<char, TrieNode*> children;
                    bool isEnd = false;
                };
                TrieNode* root;
                string stream;
            public:
                StreamChecker(vector<string>& words) {
                    root = new TrieNode();
                    for (const string& word : words) {
                        insert(word);
                    }
                }
                void insert(const string& word) {
                    TrieNode* node = root;
                    for (int i = word.size() - 1; i >= 0; i--) {
                        char c = word[i];
                        if (!node->children.count(c)) {
                            node->children[c] = new TrieNode();
                        }
                        node = node->children[c];
                    }
                    node->isEnd = true;
                }
                bool query(char letter) {
                    stream += letter;
                    TrieNode* node = root;
                    for (int i = stream.size() - 1; i >= 0; i--) {
                        char c = stream[i];
                        if (!node->children.count(c)) return false;
                        node = node->children[c];
                        if (node->isEnd) return true;
                    }
                    return false;
                }
            };
        """
            ),
            Question(
                name = "Word Squares",
                link = "https://leetcode.com/problems/word-squares/",
                solutionJava = """
            class Solution {
                public List<List<String>> wordSquares(String[] words) {
                    List<List<String>> result = new ArrayList<>();
                    Trie trie = new Trie();
                    for (String word : words) {
                        trie.insert(word);
                    }
                    backtrack(result, new ArrayList<>(), trie, words[0].length());
                    return result;
                }
                private void backtrack(List<List<String>> result, List<String> current, Trie trie, int wordLength) {
                    if (current.size() == wordLength) {
                        result.add(new ArrayList<>(current));
                        return;
                    }
                    StringBuilder prefix = new StringBuilder();
                    for (int i = 0; i < current.size(); i++) {
                        prefix.append(current.get(i).charAt(current.size()));
                    }
                    for (String word : trie.getWordsWithPrefix(prefix.toString())) {
                        current.add(word);
                        backtrack(result, current, trie, wordLength);
                        current.remove(current.size() - 1);
                    }
                }
            }
            class Trie {
                private TrieNode root;
                public Trie() {
                    root = new TrieNode();
                }
                public void insert(String word) {
                    TrieNode node = root;
                    for (char c : word.toCharArray()) {
                        node = node.children.computeIfAbsent(c, k -> new TrieNode());
                    }
                    node.isEnd = true;
                }
                public List<String> getWordsWithPrefix(String prefix) {
                    TrieNode node = root;
                    for (char c : prefix.toCharArray()) {
                        if (!node.children.containsKey(c)) return new ArrayList<>();
                        node = node.children.get(c);
                    }
                    return collectAllWords(node, prefix);
                }
                private List<String> collectAllWords(TrieNode node, String prefix) {
                    List<String> words = new ArrayList<>();
                    if (node.isEnd) words.add(prefix);
                    for (char c : node.children.keySet()) {
                        words.addAll(collectAllWords(node.children.get(c), prefix + c));
                    }
                    return words;
                }
            }
            class TrieNode {
                Map<Character, TrieNode> children = new HashMap<>();
                boolean isEnd = false;
            }
        """,
                solutionCpp = """
            class Solution {
                public:
                    vector<vector<string>> wordSquares(vector<string>& words) {
                        vector<vector<string>> result;
                        Trie trie;
                        for (const string& word : words) {
                            trie.insert(word);
                        }
                        backtrack(result, {}, trie, words[0].size());
                        return result;
                    }
                    void backtrack(vector<vector<string>>& result, vector<string> current, Trie& trie, int wordLength) {
                        if (current.size() == wordLength) {
                            result.push_back(current);
                            return;
                        }
                        string prefix;
                        for (int i = 0; i < current.size(); i++) {
                            prefix += current[i][current.size()];
                        }
                        for (const string& word : trie.getWordsWithPrefix(prefix)) {
                            current.push_back(word);
                            backtrack(result, current, trie, wordLength);
                            current.pop_back();
                        }
                    }
            };
            class Trie {
                TrieNode* root;
            public:
                Trie() {
                    root = new TrieNode();
                }
                void insert(const string& word) {
                    TrieNode* node = root;
                    for (char c : word) {
                        node = node->children[c] = node->children.count(c) ? node->children[c] : new TrieNode();
                    }
                    node->isEnd = true;
                }
                vector<string> getWordsWithPrefix(const string& prefix) {
                    TrieNode* node = root;
                    for (char c : prefix) {
                        if (!node->children.count(c)) return {};
                        node = node->children[c];
                    }
                    return collectAllWords(node, prefix);
                }
                vector<string> collectAllWords(TrieNode* node, string prefix) {
                    vector<string> words;
                    if (node->isEnd) words.push_back(prefix);
                    for (auto& [c, child] : node->children) {
                        auto childWords = collectAllWords(child, prefix + c);
                        words.insert(words.end(), childWords.begin(), childWords.end());
                    }
                    return words;
                }
            };
            class TrieNode {
            public:
                unordered_map<char, TrieNode*> children;
                bool isEnd = false;
            };
        """
            ),
            Question(
                name = "Concatenated Words",
                link = "https://leetcode.com/problems/concatenated-words/",
                solutionJava = """
            class Solution {
                public List<String> findAllConcatenatedWordsInADict(String[] words) {
                    Set<String> wordSet = new HashSet<>(Arrays.asList(words));
                    List<String> result = new ArrayList<>();
                    for (String word : words) {
                        if (canForm(word, wordSet)) {
                            result.add(word);
                        }
                    }
                    return result;
                }
                private boolean canForm(String word, Set<String> wordSet) {
                    if (wordSet.isEmpty()) return false;
                    boolean[] dp = new boolean[word.length() + 1];
                    dp[0] = true;
                    for (int i = 1; i <= word.length(); i++) {
                        for (int j = 0; j < i; j++) {
                            if (dp[j] && wordSet.contains(word.substring(j, i))) {
                                dp[i] = true;
                                break;
                            }
                        }
                    }
                    return dp[word.length()];
                }
            }
        """,
                solutionCpp = """
            class Solution {
                public:
                    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
                        unordered_set<string> wordSet(words.begin(), words.end());
                        vector<string> result;
                        for (const string& word : words) {
                            if (canForm(word, wordSet)) {
                                result.push_back(word);
                            }
                        }
                        return result;
                    }
                private:
                    bool canForm(const string& word, unordered_set<string>& wordSet) {
                        if (wordSet.empty()) return false;
                        vector<bool> dp(word.size() + 1, false);
                        dp[0] = true;
                        for (int i = 1; i <= word.size(); i++) {
                            for (int j = 0; j < i; j++) {
                                if (dp[j] && wordSet.count(word.substr(j, i - j))) {
                                    dp[i] = true;
                                    break;
                                }
                            }
                        }
                        return dp[word.size()];
                    }
            };
        """
            ),
            Question(
                name = "Prefix and Suffix Search",
                link = "https://leetcode.com/problems/prefix-and-suffix-search/",
                solutionJava = """
            class WordFilter {
                private class TrieNode {
                    Map<Character, TrieNode> children = new HashMap<>();
                    List<Integer> indices = new ArrayList<>();
                }
                private TrieNode root;
                public WordFilter(String[] words) {
                    root = new TrieNode();
                    for (int i = 0; i < words.length; i++) {
                        String word = words[i];
                        for (int j = 0; j <= word.length(); j++) {
                            String prefix = word.substring(0, j);
                            for (int k = 0; k <= word.length(); k++) {
                                String suffix = word.substring(k);
                                insert(prefix + "#" + suffix, i);
                            }
                        }
                    }
                }
                private void insert(String key, int index) {
                    TrieNode node = root;
                    for (char c : key.toCharArray()) {
                        node = node.children.computeIfAbsent(c, k -> new TrieNode());
                        node.indices.add(index);
                    }
                }
                public int f(String prefix, String suffix) {
                    TrieNode node = root;
                    String key = prefix + "#" + suffix;
                    for (char c : key.toCharArray()) {
                        if (!node.children.containsKey(c)) return -1;
                        node = node.children.get(c);
                    }
                    return node.indices.isEmpty() ? -1 : node.indices.get(node.indices.size() - 1);
                }
            }
        """,
                solutionCpp = """
            class WordFilter {
                struct TrieNode {
                    unordered_map<char, TrieNode*> children;
                    vector<int> indices;
                };
                TrieNode* root;
            public:
                WordFilter(vector<string>& words) {
                    root = new TrieNode();
                    for (int i = 0; i < words.size(); i++) {
                        string word = words[i];
                        for (int j = 0; j <= word.size(); j++) {
                            string prefix = word.substr(0, j);
                            for (int k = 0; k <= word.size(); k++) {
                                string suffix = word.substr(k);
                                insert(prefix + "#" + suffix, i);
                            }
                        }
                    }
                }
                void insert(const string& key, int index) {
                    TrieNode* node = root;
                    for (char c : key) {
                        if (!node->children.count(c)) {
                            node->children[c] = new TrieNode();
                        }
                        node->indices.push_back(index);
                        node = node->children[c];
                    }
                }
                int f(const string& prefix, const string& suffix) {
                    TrieNode* node = root;
                    string key = prefix + "#" + suffix;
                    for (char c : key) {
                        if (!node->children.count(c)) return -1;
                        node = node->children[c];
                    }
                    return node->indices.empty() ? -1 : node->indices.back();
                }
            };
        """
            ),
            Question(
                name = "Short Encoding of Words",
                link = "https://leetcode.com/problems/short-encoding-of-words/",
                solutionJava = """
            class Solution {
                public int minimumLengthEncoding(String[] words) {
                    Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
                    for (String word : words) {
                        for (int i = 1; i < word.length(); i++) {
                            uniqueWords.remove(word.substring(i));
                        }
                    }
                    int length = 0;
                    for (String word : uniqueWords) {
                        length += word.length() + 1;
                    }
                    return length;
                }
            }
        """,
                solutionCpp = """
            class Solution {
                public:
                    int minimumLengthEncoding(vector<string>& words) {
                        unordered_set<string> uniqueWords(words.begin(), words.end());
                        for (const string& word : words) {
                            for (int i = 1; i < word.size(); i++) {
                                uniqueWords.erase(word.substr(i));
                            }
                        }
                        int length = 0;
                        for (const string& word : uniqueWords) {
                            length += word.size() + 1;
                        }
                        return length;
                    }
            };
        """
            ),
            Question(
                name = "Camelcase Matching",
                link = "https://leetcode.com/problems/camelcase-matching/",
                solutionJava = """
            class Solution {
                public List<Boolean> camelMatch(String[] queries, String pattern) {
                    List<Boolean> result = new ArrayList<>();
                    for (String query : queries) {
                        result.add(matches(query, pattern));
                    }
                    return result;
                }
                private boolean matches(String query, String pattern) {
                    int j = 0;
                    for (int i = 0; i < query.length(); i++) {
                        if (j < pattern.length() && query.charAt(i) == pattern.charAt(j)) {
                            j++;
                        } else if (Character.isUpperCase(query.charAt(i))) {
                            return false;
                        }
                    }
                    return j == pattern.length();
                }
            }
        """,
                solutionCpp = """
            class Solution {
                public:
                    vector<bool> camelMatch(vector<string>& queries, string pattern) {
                        vector<bool> result;
                        for (const string& query : queries) {
                            result.push_back(matches(query, pattern));
                        }
                        return result;
                    }
                private:
                    bool matches(const string& query, const string& pattern) {
                        int j = 0;
                        for (int i = 0; i < query.size(); i++) {
                            if (j < pattern.size() && query[i] == pattern[j]) {
                                j++;
                            } else if (isupper(query[i])) {
                                return false;
                            }
                        }
                        return j == pattern.size();
                    }
            };
        """
            )
        ) // done
    )
)
