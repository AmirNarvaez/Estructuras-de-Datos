import matplotlib.pyplot as plt

tamanos = [10, 100, 1000, 10000, 100000]

erase = [5400, 113100, 1017900, 53995380, 5452387780]
deleteStack = [4260, 122680, 1053340, 21346420, 2083245560]
deleteQueue = [5240, 143360, 1578560, 88044840, 8657304400]

plt.figure(figsize=(11, 7))

plt.plot(tamanos, erase, marker='o', label='List - erase')
plt.plot(tamanos, deleteStack, marker='o', label='Stack - delete')
plt.plot(tamanos, deleteQueue, marker='o', label='Queue - delete')

plt.xscale('log')
plt.yscale('log')

plt.xlabel('Tamaño de entrada')
plt.ylabel('Tiempo (nanosegundos)')
plt.title('Comparación de erase y delete')
plt.xticks(tamanos)
plt.grid(True, which='both')
plt.legend()

plt.savefig('erase_vs_delete.png', dpi=300)
plt.show()