syms x
f6 = sqrt(1-x^2);
g6 = x^2;
xs = solve(f6-g6, x);
fi = int(f6,x,xs(1),xs(2));
gi = int(g6,x,xs(1),xs(2));
H = fi - gi;

hold
ezplot(f6)
ezplot(g6)
