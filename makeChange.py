def make_change(coins, n):
  min_coins = [None] * (n + 1)
  min_coins[0] = 0

  for i in range(n):
    for c in coins:
      if i + c <= n:
        if min_coins[i + c] is not None:
          min_coins[i + c] = min(min_coins[i] + 1, min_coins[i + c])
        else:
          min_coins[i + c] = min_coins[i] + 1
  return min_coins[-1]

print(make_change([1, 5, 10, 25], 36))
