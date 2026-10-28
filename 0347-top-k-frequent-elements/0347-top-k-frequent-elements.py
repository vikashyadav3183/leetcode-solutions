from collections import Counter
import heapq

class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:

      
        freq = Counter(nums)

        result = heapq.nlargest(k, freq.keys(), key=freq.get)

        return result