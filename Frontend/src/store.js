import { createStore } from 'vuex'

export default createStore({
  // state is where we store reactive variables
  // this.$store.state.nameOfVariable
  state: {
    recipes: [],
  },

  // we cannot update state directly, so we use mutation methods to do that
  // this.$store.commit('nameOfMutation', data)
  mutations: {
    setRecipes(state, recipes) {
      state.recipes = recipes
    },
    addRecipe(state, recipe) {
      state.recipes.push(recipe)
    },
  },

  // async methods that will trigger a mutation
  // this.$store.dispatch('nameOfAction')
  actions: {},
})
