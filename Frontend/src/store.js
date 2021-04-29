import { createStore } from 'vuex'

export default createStore({
  // state is where we store reactive variables
  // this.$store.state.nameOfVariable
  state: {
    receipts: [],
    users: [],
    rentalObjects: [],
    user: null
  },

  // we cannot update state directly, so we use mutation methods to do that
  // this.$store.commit('nameOfMutation', data)
  mutations: {
    setReceipts(state, receipts) {
      state.receipts = receipts
    },
    addReceipt(state, receipt) {
      state.receipt.push(receipt)
    },
    removeReceipt(state, receipt) {
      state.receipts = state.receipts.filter((r) => r.id != receipt.id)
    },
    setUsers(state, users) {
      state.users = users
    },
    setUser(state, user) {
      state.user = user
    },
    addUser(state, user) {
      state.users.push(user)
    },
    removeUser(state, user) {
      state.users = state.receipts.filter((u) => u.id != user.id)
    },
    setRentalObjects(state, rentalObjects) {
      state.rentalObjects = rentalObjects
    },
    addRentalObject(state, rentalObject) {
      state.rentalObject = rentalObject
    },
    removeRentalObject(state, rentalObjects) {
      state.rentalObjects = state.rentalObjects.filter(
        (r) => r.id != rentalObjects.id
      )
    },
  },

  // async methods that will trigger a mutation
  // this.$store.dispatch('nameOfAction')
  actions: {
    async fetchReceipts(store) {
      let res = await fetch('/rest/booking-receipts')
      let receipts = await res.json()
      console.log('fetchReceipts, receipts:', receipts)
      store.commit('setReceipts', receipts)
    },
    async postReceipt(store, receipt) {
      let res = await fetch('/rest/booking-receipts', {
        method: 'POST',
        body: JSON.stringify(receipt),
      })

      let receiptFromServer = await res.json()
      console.log('postReceipt, receiptsFromServer:', receiptFromServer)
      store.commit('addReceipt', receiptFromServer)
    },
    async deleteReceipt(store, receipt) {
      let res = await fetch('/rest/booking-receipts/' + receipt.id, {
        method: 'DELETE',
      })
      let deletedReceipt = await res.json()
      store.commit('removeReceipt', deletedReceipt)
    },
    async fetchUsers(store) {
      let res = await fetch('/rest/users')
      let users = res.json()
      console.log('fetchUsers, users:', users)
      store.commit('setUsers', users)
    },
    async postUser(store, user) {
      let res = await fetch('/api/registerUser', {
        method: 'POST',
        body: JSON.stringify(user),
      })

      let userFromServer = await res.json()
      console.log('postUser, userFromServer:', userFromServer)
      store.commit('setUser', userFromServer)
    },
    async deleteUser(store, user) {
      let res = await fetch('/rest/users/' + user.id, {
        method: 'DELETE',
      })
      let deletedUser = await res.json()
      store.commit('removeUser', deletedUser)
    },
    async fetchRentalObjects(store) {
      let res = await fetch('/rest/rental-objects')
      let rentalObjects = await res.json()
      console.log('fetchRentalObjects, rentalObjects:', rentalObjects)
      store.commit('setRentalObjects', rentalObjects)
    },
    async postRentalObject(store, rentalObject) {
      let res = await fetch('/rest/rental-objects', {
        method: 'POST',
        body: JSON.stringify(rentalObject),
      })

      let rentalObjectFromServer = await res.json()
      console.log(
        'postRentalObject, rentalObjectFromServer:',
        rentalObjectFromServer
      )
      store.commit('addRentalObject', rentalObjectFromServer)
    },
    async deleteRentalObject(store, rentalObject) {
      let res = await fetch('/rest/rental-objects/' + rentalObject.id, {
        method: 'DELETE',
      })
      let deletedRentalObject = await res.json()
      store.commit('removeRentalObject', deletedRentalObject)
    },
    async login(store, credentials) {
      let res = await fetch('/api/login', {
        method: 'POST',
        body: JSON.stringify(credentials)
      })

      let loggedInUser = await res.json()
      console.log('logged in user', loggedInUser)
      store.commit('setUser', loggedInUser)
    },
    async whoAmI(store) {
      let res = await fetch('/api/whoami')
      let user = await res.json()
      console.log(user);

      store.commit('setUser', user)
    },
  },
})
