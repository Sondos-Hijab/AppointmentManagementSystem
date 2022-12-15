package main_code;

	public class Providers {
	    private String id;
	    private String provider;
		
		public Providers() {
			
		}
		public Providers (String id,  String provider) {
			this.id=id;
			this.provider=provider;
		}
		public String getProviderId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public void setname(String name) {
			this.provider = name;
		}
		public String getProvider() {
			return provider;
		}

		
	
	}


