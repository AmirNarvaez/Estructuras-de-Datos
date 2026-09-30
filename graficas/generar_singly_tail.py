import matplotlib.pyplot as plt

tamanos = [10, 100, 1000, 10000, 100000]

pushFront = [2040, 7040, 32960, 233380, 3121780]
pushBack = [2040, 10940, 35780, 283060, 1943300]
popFront = [1400, 11520, 27840, 40920, 331380]
popBack = [2020, 58160, 622220, 49206020, 5075498620]
find = [7140, 115800, 848620, 59693640, 6003176980]
erase = [3980, 145660, 993320, 56565220, 5782658300]
addBefore = [3940, 108240, 1171400, 56046260, 5757023340]
addAfter = [372240, 88660, 1122240, 59370680, 6054532620]

plt.figure(figsize=(11, 7))

plt.plot(tamanos, pushFront, marker='o', label='pushFront')
plt.plot(tamanos, pushBack, marker='o', label='pushBack')
plt.plot(tamanos, popFront, marker='o', label='popFront')
plt.plot(tamanos, popBack, marker='o', label='popBack')
plt.plot(tamanos, find, marker='o', label='find')
plt.plot(tamanos, erase, marker='o', label='erase')
plt.plot(tamanos, addBefore, marker='o', label='addBefore')
plt.plot(tamanos, addAfter, marker='o', label='addAfter')

plt.xscale('log')
plt.yscale('log')

plt.xlabel('Tamaño de entrada (n)')
plt.ylabel('Tiempo total (ns)')
plt.title('Singly Linked List con Tail - Comparación de métodos')

plt.xticks(tamanos, ['10', '100', '1.000', '10.000', '100.000'])

plt.grid(True, which='both', linestyle='--', alpha=0.5)
plt.legend()
plt.tight_layout()

plt.savefig('singly_linked_list_tail.png', dpi=300)
plt.show()