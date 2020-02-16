def partition_list(nums, k):
  smaller_idx = 0
  equal_idx = 0
  larger_idx = len(nums) - 1

  while equal_idx <= larger_idx:
    num = nums[equal_idx]

    if num < k:
      nums[smaller_idx], nums[equal_idx] = nums[equal_idx], nums[smaller_idx]
      smaller_idx += 1
      equal_idx += 1
    if num == k:
      equal_idx += 1
    if num > k:
      nums[larger_idx], nums[equal_idx] = nums[equal_idx], nums[larger_idx]
      larger_idx -= 1

  return nums


print(partition_list([2, 2, 2, 5, 2, 2, 2, 2, 5], 3))
