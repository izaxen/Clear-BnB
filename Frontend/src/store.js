import { createStore } from 'vuex'
//update?
export default createStore({
  // state is where we store reactive variables
  // this.$store.state.nameOfVariable
  state: {
    receipts: [],
    rentalObjects: [],
    user: null,
    failedLogIn: false,
    searchObject: null,
    isConfirmation: false,
    uploadedImages: [],
    rentalObject: null,
  },

  // we cannot update state directly, so we use mutation methods to do that
  // this.$store.commit('nameOfMutation', data)
  mutations: {
    setReceipts(state, receipts) {
      state.receipts = receipts
    },
    setSearchObject(state, object) {
      state.searchObject = object
    },
    removeSearchObject(state) {
      state.searchObject = null
    },
    addReceipt(state, receipt) {
      state.receipts.push(receipt)
    },
    removeReceipt(state, receipt) {
      state.receipts = state.receipts.filter((r) => r.id != receipt.id)
    },
    setUser(state, user) {
      state.user = user
      state.failedLogIn = false
    },
    setFailedLogin(state, value) {
      state.failedLogIn = value
    },
    setRentalObjects(state, rentalObjects) {
      state.rentalObjects = rentalObjects
    },
    addRentalObject(state, rentalObject) {
      state.rentalObjects = rentalObject
    },
    removeRentalObject(state, rentalObjects) {
      state.rentalObjects = state.rentalObjects.filter(
        (r) => r.id != rentalObjects.id
      )
    },
    setIsConfirmation(state, isConfirmation) {
      state.isConfirmation = isConfirmation
    },
    addUploadedImages(state, images) {
      for (let image of images) {
        if (state.uploadedImages.length < 5) {
          state.uploadedImages.push(image)
        }
      }
    },
    removeUploadedImages(state) {
      state.uploadedImages = []
    },
    setRentalObject(state, object) {
      state.rentalObject = object
    },
    getImageList(state, list) {
      state.imageList = list }
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

    async postUser(store, user) {
      let res = await fetch('/api/registerUser', {
        method: 'POST',
        body: JSON.stringify(user),
      })
      let userFromServer = await res.json()
      console.log('postUser, userFromServer:', userFromServer)
      store.commit('setUser', userFromServer)
    },

    async registerUser(store, user) {
      let res = await fetch('/api/registerUser', {
        method: 'POST',
        body: JSON.stringify(user),
      })

      let loggedInUser = await res.json()
      if ('error' in loggedInUser) {
        console.log('Failed to register', loggedInUser)
        this.state.failedLogIn = true
        return
      }
      console.log('Registerd user', loggedInUser)
      store.commit('setUser', loggedInUser)
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
      console.log('rentalObjectFromServer.id', rentalObjectFromServer.id)
      return rentalObjectFromServer.id
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
        body: JSON.stringify(credentials),
      })
      let loggedInUser = await res.json()
      if ('error' in loggedInUser) {
        console.log('Failed to login', loggedInUser)
        this.state.failedLogIn = true
        return
      }
      console.log('logged in user', loggedInUser)
      store.commit('setUser', loggedInUser)
    },

    async whoAmI(store) {
      let res = await fetch('/api/whoami')
      let user = await res.json()
      console.log(user);
      store.commit('setUser', user)
    },

    async logout(store) {
      let res = await fetch('/api/logout')

      // remove user from state
      store.commit('setUser', null)
    },

    async uploadFiles(store, object) {
      let savePath = '/api/uploads/' + object.rentalId
      await fetch(savePath, {
        method: 'POST',
        body: object.formData,
      })
    },

    async getFileUrl(store, id) {
      //console.log('id',id)
      //let loadPath= '/api/uploads/ + id
      let res = await fetch('/api/uploads/P-V-jmKvrHnun7n87ATjs')
      let fileList = await res.json()
      console.log('filelist', fileList)
      store.commit('getImageList', fileList)
      
    },

    async fetchRentalObjectById(store, id) {
      
      let res = await fetch(`/rest/rental-objects/${id}`)
      let object = await res.json()
      store.commit('setRentalObject', object)
    },
  },
})
