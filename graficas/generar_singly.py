import matplotlib.pyplot as plt

tamanos = [10, 100, 1000, 10000, 100000]

pushFront = [2180, 9800, 44080, 286860, 4701560]
pushBack = [2540, 77120, 741180, 48802100, 5010670560]
popFront = [1440, 17220, 28080, 44240, 330340]
popBack = [3120, 59920, 684120, 52056500, 5465612660]
find = [7280, 101860, 947380, 55523600, 5629818080]
erase = [3760, 87880, 1102520, 55500580, 5854232660]
addBefore = [5740, 114660, 1172240, 54699020, 5819107020]
addAfter = [417400, 93260, 1091820, 58290600, 5957143540]

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
plt.title('Singly Linked List sin Tail - Comparación de métodos')

plt.xticks(tamanos, ['10', '100', '1.000', '10.000', '100.000'])

plt.grid(True, which='both', linestyle='--', alpha=0.5)
plt.legend()
plt.tight_layout()

plt.savefig('singly_linked_list.png', dpi=300)
plt.show()