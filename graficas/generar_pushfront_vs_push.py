import matplotlib.pyplot as plt

tamanos = [10, 100, 1000, 10000, 100000]

pushFront = [2180, 9800, 44080, 286860, 4701560]
push = [2180, 12780, 59500, 472260, 1172100]

plt.figure(figsize=(11, 7))

plt.plot(tamanos, pushFront, marker='o', label='List - pushFront')
plt.plot(tamanos, push, marker='o', label='Stack - push')

plt.xscale('log')
plt.yscale('log')

plt.xlabel('Tamaño de entrada')
plt.ylabel('Tiempo (nanosegundos)')
plt.title('Comparación de pushFront y push')
plt.xticks(tamanos)
plt.grid(True, which='both')
plt.legend()

plt.savefig('pushfront_vs_push.png', dpi=300)
plt.show()