package payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pet {

    @JsonProperty
    private int id;
    @JsonProperty
    private Category category;
    @JsonProperty
    private String name;
    @JsonProperty
    private String status;

    public int getId(){
        return id;
    }

    public Category category(){
        return category;
    }

    public String getName(){
        return name;
    }

    public String getStatus(){
        return status;
    }

    //required by jackson
    private Pet(){

    }

    private Pet(int id, Category category, String name, String status){
        this.id = id;
        this.category = category;
        this.name = name;
        this.status = status;
    }

    public static class Builder{

        private int id;
        private Category category;
        private String name;
        private String status;

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setCategory(Category category){
            this.category = category;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setStatus(String status){
            this.status = status;
            return this;
        }

        public Pet build(){
            return new Pet(id, category, name, status);
        }
    }
}
