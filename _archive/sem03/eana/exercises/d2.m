syms x y
f = sin(2*x+1)^2+x;
f2 = sin(2*x+1)^2+x*y;
F = int(f);
F2 = int(f2);
int(f2,y)
diff(F2,y)

double(int(f,1,5))
