export class Location {
  public id: number;
  public name: string;
  public image: string | null;
  constructor(
    id: number,
    name: string,
    image: string | null = null,
  ) {
    this.id = id;
    this.name = name;
    this.image = image;
  }
}

