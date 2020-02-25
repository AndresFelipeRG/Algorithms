def reverse(nums, start, end):
  for i in range((end - start)//2):
    nums[start + i], nums[end - 1 - i] = nums[end - 1 - i], nums[start + i]


def rotate_list(nums, k):
  reverse(nums, 0, k)
  reverse(nums, k, len(nums))
  reverse(nums, 0, len(nums))


a = [1, 2, 3, 4, 5]
rotate_list(a, 2)
print(a)
# [3, 4, 5, 1, 2]
