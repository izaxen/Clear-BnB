<template>
  <div class="modal-backdrop">
    <div class="modal">
      <header class="modal-header">
        <slot name="header">
          Login
        </slot>
        <button type="button" class="btn-close" @click="close">x</button>
      </header>

      <section class="modal-body">
        <slot name="body">  
          Modal body
        </slot>
       </section>

      <footer class="modal-footer">
        <slot name="footer">
         
        </slot>
        <button type="button" class="btn-modal" @click="close">
          Exit
        </button>
        <button type="button" class="btn-modal">Login</button>
      </footer>
    </div>
  </div>
</template>

<script>
export default {
    name: 'Modal',
    methods: {
      close() {
        this.$emit('close');
      },
    },
}
</script>

<style scoped>
/* The Modal (background) */
.modal-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.3);
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .modal {
    background: #FFFFFF;
    box-shadow: 2px 2px 20px 1px;
    overflow-x: auto;
    width: 300px;
    height: 400px;
    display: flex;
    flex-direction: column;
    border-radius: 5px;
  }

  .modal-header,
  .modal-footer {
    padding: 15px;
    display: flex;
  }

  .modal-header {
    position: relative;
    border-bottom: 1px solid #eeeeee;
    color: #4AAE9B;
    justify-content: space-between;
  }

  .modal-footer {
    display: grid;
    grid-template-columns: 1fr;
    border-top: 1px solid #eeeeee;
    
  }

  .modal-body {
    position: relative;
    padding: 20px 10px;
  }

  .btn-close {
    position: absolute;
    top: 0;
    right: 0;
    border: none;
    font-size: 20px;
    padding: 10px;
    cursor: pointer;
    font-weight: bold;
    color: #4AAE9B;
    background: transparent;
  }

  .btn-modal {
    color: white;
    background: #4AAE9B;
    border: 1px solid #4AAE9B;
    border-radius: 3px;
    width: 100px;
    margin: 3px;
    align-self: center;
    justify-self: center;
  }

  .btn-modal:hover {
    cursor: pointer;
    transform: scale(1.1);
  }

</style>