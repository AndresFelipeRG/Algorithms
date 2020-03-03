def rotate(mat):
  n = len(mat)
  for i in range((len(mat) + 1)//2):
    for j in range(i, len(mat) - 1 - i):
      mat[i][j], mat[j][-i-1], mat[-i-1][-j-1], mat[-j -
                                                    1][i] = mat[-j-1][i], mat[i][j], mat[j][-i-1], mat[-i-1][-j-1]

  return mat


mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
# Looks like
# 1 2 3
# 4 5 6
# 7 8 9

# Looks like
# 7 4 1
# 8 5 2
# 9 6 3
print(rotate(mat))
# [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
