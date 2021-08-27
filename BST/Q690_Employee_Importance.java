/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    // dfs approach
    public int getImportance(List<Employee> employees, int id) {
        Map <Integer, Employee> list = new HashMap<>();
        for(Employee ee: employees){
            list.put(ee.id, ee);
        }

        return dfs(id, list);
    }

    private int dfs(int id, Map<Integer, Employee> map){
        Employee ee = map.get(id);
        int sum = ee.importance;
        for(int subId: ee.subordinates)
            sum += dfs(subId, map);
        return sum;
    }
}
