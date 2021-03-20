#!/usr/bin/env python
import pandas as pd
import matplotlib.pyplot as plt
import glob
import sys
import os

name = sys.argv[1]

files = glob.glob("*.csv")

df_big = []
for file in files:
    df = pd.read_csv(file, index_col=None, header=0)
    df_big.append(df)

df = pd.concat(df_big, axis=0, ignore_index=True)

df.set_index('timestamp', inplace=True)
df.sort_index(inplace=True)

df = df/1000

print(df.current.describe(percentiles=[0.9,0.95,0.99]))

ax = df.current.plot()

ax.set_title('Idle Current on Pixel 4')
ax.set_ylabel('Current mA')
ax.set_xlabel('Count')

png_file = name + '.png'
plt.savefig(png_file)
