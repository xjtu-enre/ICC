package entity.json;

public class PackageEntity extends BaseEntity {

  public PackageEntity() {
  }

  public PackageEntity(int id, int parentId, String category, String name, String qualifiedName, boolean external) {
    super(id, parentId, category, name, qualifiedName, external);
  }
}
