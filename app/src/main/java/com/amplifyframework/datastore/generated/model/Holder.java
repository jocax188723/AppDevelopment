package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Holder type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Holders", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Holder implements Model {
  public static final QueryField ID = field("Holder", "id");
  public static final QueryField COMPLETED_AT = field("Holder", "completedAt");
  public static final QueryField DATA = field("Holder", "data");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime completedAt;
  private final @ModelField(targetType="Float") List<Double> data;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public Temporal.DateTime getCompletedAt() {
      return completedAt;
  }
  
  public List<Double> getData() {
      return data;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Holder(String id, Temporal.DateTime completedAt, List<Double> data) {
    this.id = id;
    this.completedAt = completedAt;
    this.data = data;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Holder holder = (Holder) obj;
      return ObjectsCompat.equals(getId(), holder.getId()) &&
              ObjectsCompat.equals(getCompletedAt(), holder.getCompletedAt()) &&
              ObjectsCompat.equals(getData(), holder.getData()) &&
              ObjectsCompat.equals(getCreatedAt(), holder.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), holder.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCompletedAt())
      .append(getData())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Holder {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("completedAt=" + String.valueOf(getCompletedAt()) + ", ")
      .append("data=" + String.valueOf(getData()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static CompletedAtStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Holder justId(String id) {
    return new Holder(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      completedAt,
      data);
  }
  public interface CompletedAtStep {
    BuildStep completedAt(Temporal.DateTime completedAt);
  }
  

  public interface BuildStep {
    Holder build();
    BuildStep id(String id);
    BuildStep data(List<Double> data);
  }
  

  public static class Builder implements CompletedAtStep, BuildStep {
    private String id;
    private Temporal.DateTime completedAt;
    private List<Double> data;
    @Override
     public Holder build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Holder(
          id,
          completedAt,
          data);
    }
    
    @Override
     public BuildStep completedAt(Temporal.DateTime completedAt) {
        Objects.requireNonNull(completedAt);
        this.completedAt = completedAt;
        return this;
    }
    
    @Override
     public BuildStep data(List<Double> data) {
        this.data = data;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Temporal.DateTime completedAt, List<Double> data) {
      super.id(id);
      super.completedAt(completedAt)
        .data(data);
    }
    
    @Override
     public CopyOfBuilder completedAt(Temporal.DateTime completedAt) {
      return (CopyOfBuilder) super.completedAt(completedAt);
    }
    
    @Override
     public CopyOfBuilder data(List<Double> data) {
      return (CopyOfBuilder) super.data(data);
    }
  }
  
}
