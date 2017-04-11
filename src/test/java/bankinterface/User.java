package bankinterface;
 public class User {  
  
        private String name;  
        private String sex;  
        private String password;  
        private Integer age;
        
        public String getName() {  
            return name;  
        }  
        public void setName(String name) {  
            this.name = name;  
        }  
        public String getSex() {  
            return sex;  
        }  
        public void setSex(String sex) {  
            this.sex = sex;  
        }  
        public String getPassword() {  
            return password;  
        }  
        public void setPassword(String password) {  
            this.password = password;  
        }
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}  
    }  
  