def reverse(s, start, end):
  for i in range(0, (end - start)//2):
    s[start + i], s[end - i - 1] = s[end - i - 1], s[start + i]


def reverse_words(words):
  reverse(words, 0, len(words))
  start = 0
  idx = 0
  while idx < len(words):
    if words[idx] == ' ':
      reverse(words, start, idx)

      while idx + 1 < len(words) and words[idx + 1] == ' ':
        idx += 1
      start = idx + 1

    idx += 1

  reverse(words, start, len(words))


s = list("can you read this")
reverse_words(s)
print(''.join(s))
# this read you can
