import sys
def solve():
   try:
      n_line=input()
      if not n_line:
         return
      n = int(n_line)
   except ValueError :
     return
     
   remaining_orders = []
   for i in range(n):
      line = input().split()
      if not line:
         continue
      arrival = int(line[0])
      packing = int(line[1])
      priority = int(line[2])
      remaining_orders.append((arrival,packing,priority,i))
   current_time=0
   wait_intervals = []
   for _ in range(n):
      if not remaining_orders:
         break
      min_arrival=float('inf')
      for order in remaining_orders:
         min_arrival = min(min_arrival, order[0])
      current_time = max(current_time, min_arrival)
      elgible_orders = [order for order in remaining_orders if order[0]<= current_time]
      elgible_orders.sort(key=lambda x:(1-x[2],x[0],x[1]))
      chosen_order = elgible_orders[0]
      start_time = current_time 
      end_time = start_time + chosen_order[1]
      if start_time > chosen_order[0]:
         wait_intervals.append((chosen_order[0],start_time))
      current_time = end_time 
      for i in range(len(remaining_orders)):
      if remaining_orders[i][3] == chosen_order[3]:
         remaining_orders.pop(i)
         break
   if not wait_intervals:
     print(0)
     return
   event=[]
   for arrival,start in wait_intervals:
      events.append((arrival,1))
      events.append((start,-1))
      
   events.sort()
   
   max_chairs = 0 
   current_chairs = 0 
   for time, type in events: 
      current_chairs += type 
      max_chairs = max(max_chairs, current_chairs)
      
   print(max_chairs)
   
solve()
