syms r s t
fx = s+2*t == 2;
fy = -7*r+t == 12;
fz = 2*r+4*s+8*t == 4;

solve(fx,fy,fz,r,s,t)
