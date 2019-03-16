package payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    @JsonProperty
    private int id;
    @JsonProperty
    private String name;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    //required by jackson
    private Category(){

    }

    private Category(int id, String name){
        this.id =id;
        this.name = name;
    }

    public static class Builder{

            private int id;
            private String name;

            public Builder setId(int id){
                this.id = id;
                return this;
            }

            public Builder setName(String name){
                this.name = name;
                return this;
            }

            public Category build(){
                return new Category(id, name);
            }

    }
}
