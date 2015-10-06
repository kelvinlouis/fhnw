
class App {
	public static void main(String[] args) {
		Person person = new Person();
		person.setHeight(170);

		Employee employee = new Employee(3500);

		employee.setHeight(180);
		employee.promote();
		System.out.println(employee.getHeight());

		Customer customer = new Customer();
		System.out.println(customer.getNumber());
	}
}