export interface PokemonsDto {
  count: number;
  next: String;
  previous: String | null;
  results: PokemonsListDto[];
}

export interface PokemonsListDto {
  name: string;
  url: String;
}
export interface PokemonDetailDto {
  id : number;
  name: string;
  types: PokemonDetailListTypeDTO [];
  sprites: PokemonDetailSpriteDto;
}
export interface PokemonDetailListTypeDTO {
    slot: number;
    type: PokemonDetailTypeDTO
  }

export interface PokemonDetailTypeDTO {
  name: string;
  url: String;
}

export interface PokemonDetailSpriteDto {
  front_default: String;
  front_shiny: String;
}

