#!/usr/bin/env python
import pandas as pd
import matplotlib.pyplot as plt
import sys
import os

csv_file = sys.argv[1]

df = pd.read_csv(csv_file)

df = df/1000

print(df.current.describe(percentiles=[0.9,0.95,0.99]))

ax = df.current.plot()

ax.set_title('Idle Current on Pixel 4')
ax.set_ylabel('Current mA')
ax.set_xlabel('Count')

png_file = os.path.splitext(csv_file)[0] + '.png'
plt.savefig(png_file)
