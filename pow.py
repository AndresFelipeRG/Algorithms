def pow(x, n):
  result = 1
  while n > 0:
    if n % 2 == 1:
      result *= x
      n -= 1
    x *= x
    n //= 2

  return result


print(pow(5, 3))
# 125
