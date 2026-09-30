import matplotlib.pyplot as plt

tamanos = [10, 100, 1000, 10000, 100000]

enqueue = [1960, 11540, 60640, 349300, 1076860]
dequeue = [2140, 12900, 35040, 79720, 365140]
front = [3840, 8620, 26220, 98420, 297200]
isEmpty = [1280, 6220, 24680, 50440, 232340]
size = [1100, 11480, 31080, 32920, 249180]
delete = [5240, 143360, 1578560, 88044840, 8657304400]

plt.figure(figsize=(11, 7))

plt.plot(tamanos, enqueue, marker='o', label='enqueue')
plt.plot(tamanos, dequeue, marker='o', label='dequeue')
plt.plot(tamanos, front, marker='o', label='front')
plt.plot(tamanos, isEmpty, marker='o', label='isEmpty')
plt.plot(tamanos, size, marker='o', label='size')
plt.plot(tamanos, delete, marker='o', label='delete')

plt.xscale('log')
plt.yscale('log')

plt.xlabel('Tamaño de entrada (n)')
plt.ylabel('Tiempo total (ns)')
plt.title('MyQueueArray - Comparación de métodos')

plt.xticks(tamanos, ['10', '100', '1.000', '10.000', '100.000'])

plt.grid(True, which='both', linestyle='--', alpha=0.5)
plt.legend()
plt.tight_layout()

plt.savefig('queue.png', dpi=300)
plt.show()