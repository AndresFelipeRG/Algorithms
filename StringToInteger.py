def convert_to_int(s):
  if not s:
    return None

  result = 0
  is_negative = False

  if s[0] == '-':
    is_negative = True
    s = s[1:]

  ascii_zero = ord('0')

  for ch in s:
    if not ch.isdigit():
      return None
    result = result * 10 + ord(ch) - ascii_zero

  return -result if is_negative else result


print(convert_to_int(
