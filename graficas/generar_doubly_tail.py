import matplotlib.pyplot as plt

tamanos = [10, 100, 1000, 10000, 100000]

pushFront = [2820, 7880, 36120, 282480, 1990180]
pushBack = [3320, 13420, 39040, 409940, 1210720]
popFront = [2880, 9520, 26760, 59500, 467840]
popBack = [2640, 37920, 28780, 94280, 494440]
find = [10220, 140860, 972220, 60207680, 6159974440]
erase = [5400, 113100, 1017900, 53995380, 5452387780]
addBefore = [4180, 119980, 1235160, 55039040, 7416742700]
addAfter = [385520, 91400, 1251800, 58199180, 5937669400]

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
plt.title('Doubly Linked List con Tail - Comparación de métodos')

plt.xticks(tamanos, ['10', '100', '1.000', '10.000', '100.000'])

plt.grid(True, which='both', linestyle='--', alpha=0.5)
plt.legend()
plt.tight_layout()

plt.savefig('doubly_linked_list_tail.png', dpi=300)
plt.show()