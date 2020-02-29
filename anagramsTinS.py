from collections import defaultdict


def find_anagrams(s, t):
  result = []

  ch_map = defaultdict(int)
  for ch in t:
    ch_map[ch] += 1

  for idx in range(len(s)):
    ch = s[idx]

    if idx >= len(t):
      old_ch = s[idx - len(t)]
      ch_map[old_ch] += 1
      if ch_map[old_ch] == 0:
        del ch_map[old_ch]

    ch_map[ch] -= 1
    if ch_map[ch] == 0:
      del ch_map[ch]

    if idx + 1 >= len(t) and len(ch_map) == 0:
      result.append(idx - len(t) + 1)

  return result


print(find_anagrams('acdbacdacb', 'abc'))
# [3, 7]
