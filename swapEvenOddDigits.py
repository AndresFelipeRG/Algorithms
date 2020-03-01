MASK_EVEN = 0b10101010101010101010101010101010
MASK_ODD = 0b01010101010101010101010101010101


def swap_bits(num):
  return ((num & MASK_EVEN) >> 1) | ((num & MASK_ODD) << 1)


print(f"0b{swap_bits(0b10101010101010101010101010101010):032b}")
# 0b01010101010101010101010101010101
