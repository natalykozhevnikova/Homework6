package Homework6;

import java.util.*;

    public class Notebook {
        private int id;
        private String name;
        private int memory;
        private String processor;
        private Double display;
        private int price;

        public Notebook(int id, String name, int memory,
                    String processor, Double display, int price) {
            this.id = id;
            this.name = name;
            this.memory = memory;
            this.processor = processor;
            this.display = display;
            this.price = price;
        }

        public int getId() {

            return id;
        }

        public void setId(int id) {

            this.id = id;
        }

        public String getName() {

            return name;
        }

        public void setName(String name) {

            this.name = name;
        }

        public int getMemory() {


            return memory;
        }

        public void setMemory(int Memory) {

            this.memory = memory;
        }
        public String getProcessor() {

            return processor;
        }

        public void setProcessor(String processor) {

            this.processor = processor;
        }

        public Double getDisplay() {

            return display;
        }

        public void setDisplay(Double display) {

            this.display = display;
        }
        public int getPrice() {

            return price;
        }

        public void setPrice(int price) {

            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Notebook notebook = (Notebook) o;
            return id == notebook.id && memory == notebook.memory && Objects.equals(name, notebook.name) && Objects.equals(processor, notebook.processor)
                    && Objects.equals(display, notebook.display) && Objects.equals(price, notebook.price);
        }

        @Override
        public int hashCode() {

            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "Notebook {" +
                    "id: " + id +
                    ", Наименование: " + name +
                    ", Объем памяти: " + memory +
                    ", Процессор: " + processor +
                    ", Дисплей: " + display +
                    ", Стоимость: " + price +
                    '}';
        }

        public static Set<Notebook> createNotebookSet() {
            Set<Notebook> notebookSet = new HashSet<>();
            notebookSet.add(new Notebook(1, "name1", 1, 1, "processor1",
                    "display1", 1.0, 1.0, 1));
            notebookSet.add(new Notebook(2, "name2", 2, 2, "processor2",
                    "display2", 2.0, 2.0, 2));
            notebookSet.add(new Notebook(3, "name3", 1, 1, "processor3",
                    "display3", 1.0, 1.0, 1));
            notebookSet.add(new Notebook(4, "name4", 4, 4, "processor4",
                    "display4", 4.0, 4.0, 4));
            notebookSet.add(new Notebook(5, "name5", 5, 5, "processor5",
                    "display5", 5.0, 5.0, 5));
            notebookSet.add(new Notebook(6, "name6", 1, 1, "processor6",
                    "display6", 1.0, 1.0, 1));
            for (Notebook i : notebookSet) {
                System.out.println(i);
            }
            return notebookSet;
        }

        public static Map<String, String> enterFilter() {
            Map<String, String> filterMap = new HashMap<>();
            String key = "";
            while (!key.equals("q")) {
                System.out.printf("Выберите нужную цифру:\n" +
                        "1 - Наименование\n" +
                        "2 - Объем памяти\n" +
                        "3 - Процессор\n" +
                        "4 - Дисплей\n" +
                        "5 - Стоимость\n" +
                        "6 - Сохранить поиск и выйти\n" +
                        "-> ");
                Scanner scn = new Scanner(System.in);
                key = scn.nextLine();
                if (!key.equals("q")) {
                    System.out.printf("Введите значение критерия:\n" +
                            "-> ");
                    String value = scn.nextLine();
                    filterMap.put(key, value);
                }
            }
            return filterMap;
        }

        public static boolean selectionByFilter(Notebook notebook, Map<String, String> filterMap) {
            Boolean result = false;
            Integer count = 0;
            for (String key : filterMap.keySet()) {
                if (key.equals("1")) {
                    if (filterMap.get("1").equals(notebook.name)) {
                        count += 1;
                    }
                }
                if (key.equals("2")) {
                    int intValue = Integer.parseInt(filterMap.get("2"));
                    if (intValue <= notebook.memory) {
                        count += 1;
                    }
                }
                if (key.equals("3")) {
                    if (filterMap.get("3").equals(notebook.processor)) {
                        count += 1;
                    }
                }
                if (key.equals("4")) {
                    double doubleValue = Double.parseDouble(filterMap.get("4"));
                    if (doubleValue <= notebook.display) {
                        count += 1;
                    }
                }
                if (key.equals("5")) {
                    int intValue = Integer.parseInt(filterMap.get("5"));
                    if (intValue <= notebook.price) {
                        count += 1;
                    }
                }
            }
            if ((filterMap.keySet().size()) == count) {
                result = true;
            }
            return result;
        }

        public static void main(String[] args) {
            Set<Notebook> notebookSet = createNotebookSet();
            Map<String, String> filterMap = enterFilter();
            for (Notebook notebook : notebookSet) {
                if (selectionByFilter(notebook, filterMap)) {
                    System.out.println(notebook);
                }
            }
        }
    }

