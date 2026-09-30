import matplotlib.pyplot as plt

tamanos = [10, 100, 1000, 10000, 100000]

push = [2180, 12780, 59500, 472260, 1172100]
pop = [2260, 15000, 38480, 65320, 319960]
peek = [1420, 21900, 26900, 85400, 289960]
isEmpty = [1320, 9220, 25540, 132820, 222080]
size = [1180, 11880, 24820, 24540, 250680]
delete = [4260, 122680, 1053340, 21346420, 2083245560]

plt.figure(figsize=(11, 7))

plt.plot(tamanos, push, marker='o', label='push')
plt.plot(tamanos, pop, marker='o', label='pop')
plt.plot(tamanos, peek, marker='o', label='peek')
plt.plot(tamanos, isEmpty, marker='o', label='isEmpty')
plt.plot(tamanos, size, marker='o', label='size')
plt.plot(tamanos, delete, marker='o', label='delete')

plt.xscale('log')
plt.yscale('log')

plt.xlabel('Tamaño de entrada (n)')
plt.ylabel('Tiempo total (ns)')
plt.title('MyStackArray - Comparación de métodos')

plt.xticks(tamanos, ['10', '100', '1.000', '10.000', '100.000'])

plt.grid(True, which='both', linestyle='--', alpha=0.5)
plt.legend()
plt.tight_layout()

plt.savefig('stack.png', dpi=300)
plt.show()