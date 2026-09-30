import matplotlib.pyplot as plt

tamanos = [10, 100, 1000, 10000, 100000]

popFront = [1440, 17220, 28080, 44240, 330340]
dequeue = [2140, 12900, 35040, 79720, 365140]

plt.figure(figsize=(11, 7))

plt.plot(tamanos, popFront, marker='o', label='List - popFront')
plt.plot(tamanos, dequeue, marker='o', label='Queue - dequeue')

plt.xscale('log')
plt.yscale('log')

plt.xlabel('Tamaño de entrada')
plt.ylabel('Tiempo (nanosegundos)')
plt.title('Comparación de popFront y dequeue')
plt.xticks(tamanos)
plt.grid(True, which='both')
plt.legend()

plt.savefig('popfront_vs_dequeue.png', dpi=300)
plt.show()