export class listInfo {
  title: string;
  listType: string;
  listScope: string;

  public constructor (title: string, listType: string, listScope: string){
    this.title = title;
    this.listType = listType;
    this.listScope = listScope;
  }
}