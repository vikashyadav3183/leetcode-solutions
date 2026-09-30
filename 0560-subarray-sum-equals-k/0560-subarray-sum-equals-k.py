class Solution:
    def subarraySum(self, nums, k):
        mp = {0: 1}
        sum = 0
        count = 0

        for num in nums:
            sum += num

            if sum - k in mp:
                count += mp[sum - k]

            mp[sum] = mp.get(sum, 0) + 1

        return count
