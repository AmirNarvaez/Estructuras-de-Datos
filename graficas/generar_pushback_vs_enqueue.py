import matplotlib.pyplot as plt

tamanos = [10, 100, 1000, 10000, 100000]

pushBack = [2040, 10940, 35780, 283060, 1943300]
enqueue = [1960, 11540, 60640, 349300, 1076860]

plt.figure(figsize=(11, 7))

plt.plot(tamanos, pushBack, marker='o', label='List - pushBack')
plt.plot(tamanos, enqueue, marker='o', label='Queue - enqueue')

plt.xscale('log')
plt.yscale('log')

plt.xlabel('Tamaño de entrada')
plt.ylabel('Tiempo (nanosegundos)')
plt.title('Comparación de pushBack y enqueue')
plt.xticks(tamanos)
plt.grid(True, which='both')
plt.legend()

plt.savefig('pushback_vs_enqueue.png', dpi=300)
plt.show()